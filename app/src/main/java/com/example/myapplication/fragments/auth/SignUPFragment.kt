package com.example.myapplication.fragments.auth

import Database.UserViewModel
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.databinding.FragmentRegistrationBinding
import com.example.myapplication.databinding.InvalidCredentialsDialogBinding
import com.google.android.material.button.MaterialButton
import model.User

class SignUPFragment : Fragment() {


    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val signUpBtn = binding.signUpButton
        signUpBtn.setOnClickListener{registerNewUser()}
        return binding.root
    }

    private fun openMarketFragment(){
        val navController = Navigation.findNavController(requireActivity(),R.id.host_fragment_activity_main)
        navController.navigate(R.id.action_registrationFragment_to_navigation_pay)
    }

    private fun registerNewUser(){
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val email = binding.userEmail.text.toString()
        val password = binding.userPassword.text.toString()
        if(inputCheck(firstName,lastName,email,password)){
            //Create new user
            val user = User(0,firstName,lastName,email,password)
            //Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Приятных покупок , $firstName !",Toast.LENGTH_SHORT).show()
            //Navigate to main fragment
            openMarketFragment()
        }
        else{
            openInvalidCredentialsDialog()
        }
    }

    private fun inputCheck(firstName: String , lastName : String , email : String , password : String):Boolean{
        return !(
                TextUtils.isEmpty(firstName)
                        || TextUtils.isEmpty(lastName)
                        ||TextUtils.isEmpty(email)
                        ||TextUtils.isEmpty(password)
                )
    }
    private fun openInvalidCredentialsDialog(){
        val dialog = Dialog(binding.root.context)
        dialog.setContentView(R.layout.invalid_credentials_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val okBtn = dialog.findViewById<MaterialButton>(R.id.ok_btn)
        val mainText = dialog.findViewById<TextView>(R.id.textView)
        mainText.text = getString(R.string.invalid_creds)
        okBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

}