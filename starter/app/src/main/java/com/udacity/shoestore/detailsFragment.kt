package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailsBinding
import com.udacity.shoestore.models.SaveState
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoesViewModel


class detailsFragment : Fragment() {
    private val viewModel : ShoesViewModel by activityViewModels()

    private val shoeData = Shoe("", 0, "", "")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(
            inflater, container, false
        )

        binding.shoesViewModel=viewModel
        binding.lifecycleOwner = this
        binding.shoeData = shoeData

        binding.cancel.setOnClickListener {
            val action = detailsFragmentDirections.actionDetailsFragmentToShoeListFragment()
            findNavController().navigate(action)
        }
        viewModel.saveState.observe(this as LifecycleOwner, Observer{ save ->
            when(save) {
                SaveState.SAVE -> {
                    navigateToShoeList()
                    viewModel.onEventSaveComplete()
                }
            }
        })
        return binding.root
    }
    private  fun navigateToShoeList() {
        val action = detailsFragmentDirections.actionDetailsFragmentToShoeListFragment()
        findNavController().navigate(action)

    }


}