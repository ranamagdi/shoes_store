package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ViewshoeBinding
import com.udacity.shoestore.models.ShoesViewModel
import timber.log.Timber


class shoeListFragment : Fragment() {


    private val viewModel : ShoesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding : FragmentShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)

        viewModel.shoeList.observe(this as LifecycleOwner, Observer {

            for (shoe in viewModel.shoeList.value!!) {
                val inBinding = ViewshoeBinding.inflate(layoutInflater)
                inBinding.shoeData = shoe
                binding.linearLayoutShoeList.addView(inBinding.root)
            }
        })

        binding.addShoeButton.setOnClickListener {
            Timber.i("in addShoeButton listener")
            Timber.i(viewModel.shoeList.value?.joinToString(separator = "\n"))
            val action = shoeListFragmentDirections.actionShoeListFragmentToDetailsFragment()
            findNavController().navigate(action)
        }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().navigate(shoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
        return true
    }


}