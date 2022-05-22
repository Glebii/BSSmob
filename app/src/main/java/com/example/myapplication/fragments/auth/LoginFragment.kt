package com.example.myapplication.fragments.auth

import Database.UserViewModel
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {


    private lateinit var binding: FragmentLoginBinding
    private lateinit var mUserViewModel: UserViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        val textView = binding.signUpText
        val loginButton = binding.buttonLogIn
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        loginButton.setOnClickListener{openMarketFragment()}
        textView.setOnClickListener{openSignupFragment()}
        return binding.root
    }

    private fun loginUser(){
        val email = binding.userEmail.text.toString()
        val password = binding.userPassword.text.toString()


    }
    private fun openSignupFragment(){
        val navController = Navigation.findNavController(requireActivity(),R.id.host_fragment_activity_main)

        navController.navigate(R.id.action_loginFragment_to_registrationFragment)
    }
    private fun openMarketFragment(){
        val navController = Navigation.findNavController(requireActivity(),R.id.host_fragment_activity_main)
        navController.navigate(R.id.action_loginFragment_to_navigation_pay)
    }


}