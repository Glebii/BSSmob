package com.example.myapplication

import android.app.Activity
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.FragmentBoardBinding
import on_boarding.ViewPagerOnBoardingAdapter


class BoardFragment : Fragment() {

    private lateinit var binding: FragmentBoardBinding
    private lateinit var viewPagerAdapter: ViewPagerOnBoardingAdapter
    private lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View
    {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        binding = FragmentBoardBinding.inflate(inflater,container,false)
        val dotsIndicator = binding.dotsIndicator
        val continueButton = binding.buttonContinue
        val animDrawable = binding.root.background as AnimationDrawable
        addAnimation(animDrawable)
        viewPager = binding.onboardingViewpager
        viewPagerAdapter = ViewPagerOnBoardingAdapter(binding.root.context)
        viewPager.adapter =  viewPagerAdapter
        dotsIndicator.setViewPager(viewPager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}

            override fun onPageSelected(position: Int) {
                if (position== 0){
                    binding.root.setBackgroundResource(R.drawable.gradient_animation_first_screen_onboarding)
                    val animDrawable = binding.root.background as AnimationDrawable
                    addAnimation(animDrawable)
                    if(continueButton.visibility == View.VISIBLE){
                        continueButton.visibility = View.INVISIBLE
                    }

                }
                if (position== 1){
                    binding.root.setBackgroundResource(R.drawable.gradient_animation_second_screen_onboarding)
                    val animDrawable = binding.root.background as AnimationDrawable
                    addAnimation(animDrawable)
                    if(continueButton.visibility == View.VISIBLE){
                        continueButton.visibility = View.INVISIBLE
                    }
                }
                if (position== 2) {
                    binding.root.setBackgroundResource(R.drawable.gradient_animation_third_screen_onboarding)
                    val animDrawable = binding.root.background as AnimationDrawable
                    addAnimation(animDrawable)
                    continueButton.visibility = View.VISIBLE
                    continueButton.setOnClickListener { openRegistrationFragment() }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
        return binding.root
    }

    private fun openRegistrationFragment(){
        val navController = Navigation.findNavController(requireActivity(),R.id.host_fragment_activity_main)

        navController.navigate(R.id.action_boardFragment_to_registrationFragment)
    }
    fun addAnimation(animationDrawable: AnimationDrawable){
    animationDrawable.setEnterFadeDuration(2000)
    animationDrawable.setExitFadeDuration(3000)
    animationDrawable.start()
    }

}

