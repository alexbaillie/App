package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.app.databinding.ProfileBinding
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter


class Profile : Fragment(){

    private var _binding: ProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {

            val userName: String = binding.Name.text.toString()
            val email: String = binding.Email.text.toString()
            val password: String = binding.Password.text.toString()


            val file: File = File(activity?.applicationContext?.filesDir,  "userData.txt")
            val writer: FileWriter = FileWriter(file)

            writer.write("$userName ")
            writer.write("$email ")
            writer.write("$password\n")
            writer.close()

            // action is actually the inverse of its name
            findNavController().navigate(R.id.action_FirstFragment_to_Profile)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}