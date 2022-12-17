package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


class loginFragment : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false)
        binding.loginButtonFragmentLogin.setOnClickListener {
            navigateToWelcomeFragment()
        }

        binding.registerButtonFragmentLogin.setOnClickListener {
            navigateToWelcomeFragment()
        }
        return binding.root

    }

    private fun navigateToWelcomeFragment() {
        findNavController().navigate(loginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }


}