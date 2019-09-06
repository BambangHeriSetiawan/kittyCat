package com.simx.kittycat.ui.home.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.simx.kittycat.R
import com.simx.kittycat.data.model.CatTypes
import com.simx.kittycat.data.model.Cats
import com.simx.kittycat.databinding.DetailCatActivityBinding

class DetailCatActivity : AppCompatActivity() {
    private lateinit var binding:DetailCatActivityBinding
    private lateinit var vm:DetailCatActivityVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.detail_cat_activity)
        vm = DetailCatActivityVM()
        binding.lifecycleOwner = this
        binding.detailCatVm = vm
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        intent.extras.let { bundle -> run {
            if (!bundle?.isEmpty!!)initUi(bundle.getParcelable(KEY_DATA))
        } }

    }

    private fun initUi(dataCats: CatTypes.DataCats?) {
        binding.vpDetail.adapter = dataCats?.data?.let { PageAdapterCats(it) }
        binding.tabIndicator.setupWithViewPager(binding.vpDetail, true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
    companion object {
        const val KEY_DATA = "key_data"
        fun start(context: Context, data: CatTypes.DataCats?){
            val intent = Intent(context, DetailCatActivity::class.java)
            intent.putExtra(KEY_DATA, data)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}
