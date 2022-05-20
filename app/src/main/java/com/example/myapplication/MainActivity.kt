package com.example.myapplication

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RelativeLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.myapplication.databinding.ActivityMainBinding
import on_boarding.ViewPagerOnBoardingAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerOnBoardingAdapter
    private lateinit var viewPager: ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        val dotsIndicator = binding.dotsIndicator
        val continueButton = binding.buttonContinue
        val animDrawable = binding.root.background as AnimationDrawable
        addAnimation(animDrawable)
        viewPager = binding.onboardingViewpager
        viewPagerAdapter = ViewPagerOnBoardingAdapter(this)
        viewPager.adapter =  viewPagerAdapter
        dotsIndicator.setViewPager(viewPager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

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
                if (position== 2){
                    binding.root.setBackgroundResource(R.drawable.gradient_animation_third_screen_onboarding)
                    val animDrawable = binding.root.background as AnimationDrawable
                    addAnimation(animDrawable)
                    continueButton.visibility = View.VISIBLE
                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }
    fun addAnimation(animationDrawable: AnimationDrawable){
        animationDrawable.setExitFadeDuration(5)
        animationDrawable.setExitFadeDuration(3000)
        animationDrawable.start()
    }
}