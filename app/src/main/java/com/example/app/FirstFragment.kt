package com.example.app

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.FragmentFirstBinding
import android.view.MenuItem
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

    override fun onResume() {
        super.onResume()

        val trialViewModel = ViewModelProvider(requireActivity()).get(VM::class.java)

        trialViewModel.isRegistered.observe(viewLifecycleOwner, Observer {
            if (it){
                binding.imageButton.setOnClickListener {
                    findNavController().navigate(R.id.action_FirstFragment_to_logIn)
                }
            } else {
                binding.imageButton.setOnClickListener {
                    findNavController().navigate(R.id.action_FirstFragment_to_Profile)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}