package com.simx.kittycat.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.simx.kittycat.MainActivity
import com.simx.kittycat.R
import com.simx.kittycat.databinding.ProfileFragmentBinding
import com.simx.kittycat.helper.Pref
import com.simx.kittycat.ui.login.LoginActivity

class ProfileFragment : Fragment() {
    private lateinit var binding:ProfileFragmentBinding
    private lateinit var vm:ProfileVM
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.profile_fragment, container,false)
        vm = ProfileVM(Pref(this.context!!))
        binding.lifecycleOwner = this
        binding.profileVm = vm
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogout.setOnClickListener {
            vm.logout()
            LoginActivity.start(this.context!!)
            (activity as MainActivity).finish()
        }
    }
}