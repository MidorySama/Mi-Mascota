package com.example.mimascota.activities.splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mimascota.R
import com.example.mimascota.activities.main.MainActivity
import com.example.mimascota.databinding.ActivitySplashBinding
import com.example.mimascota.views.loguin.LoguinFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MiMascota)
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startLottieAnimation()
    }

    private fun startLottieAnimation() {

        binding.animationStartLottie.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator?) {

            }

            override fun onAnimationEnd(animation: Animator?) {
                startActivity()
            }

            override fun onAnimationCancel(animation: Animator?) {

            }

            override fun onAnimationRepeat(animation: Animator?) {

            }
        })

        binding.animationStartLottie.playAnimation()
    }

    fun startActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}
