package com.simx.kittycat.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simx.kittycat.R
import com.simx.kittycat.data.model.CatTypes
import com.simx.kittycat.databinding.HomeFragmentBinding
import com.simx.kittycat.ui.home.detail.DetailCatActivity

class HomeFragment : Fragment() {
    private lateinit var binding:HomeFragmentBinding
    private lateinit var vm:HomeVM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.home_fragment, container,false)
        vm = HomeVM()
        binding.lifecycleOwner = this
        binding.homeVm = vm
        vm.getCatTypes()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.catTypes.observe(this, Observer { data -> run {
            data.let {
             binding.rcvCatTypes.apply {
                 hasFixedSize()
                 itemAnimator = DefaultItemAnimator()
                 layoutManager = LinearLayoutManager(this@HomeFragment.context!!, RecyclerView.VERTICAL, false)
                 adapter = AdapterCatTypes(it, object : AdapterCatTypes.OnAdapterCatTypesListener {
                     override fun onClicked(data: CatTypes.DataCats?) {
                         DetailCatActivity.start(this@HomeFragment.context!!, data)
                     }
                 })
             }
            }
        } })
    }
}