package com.example.chatgpt_clone.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import androidx.fragment.app.Fragment
import com.example.chatgpt_clone.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    lateinit var binding : FragmentIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroBinding.inflate(layoutInflater , container , false)
        animation()
        binding.animIntro.playAnimation()

        return binding.root
    }

    private fun animation() {
        val anim = AlphaAnimation(0f, 2f)
        anim.duration = 2000L
        anim.fillAfter = true
        val anim2 = RotateAnimation(
            0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        anim2.duration = 1000L
        anim2.fillAfter = true


        binding.animIntro.playAnimation()
        binding.txtAppName.startAnimation(anim)
        binding.txtVersion.startAnimation(anim)
        binding.animIntro.startAnimation(anim2)

    }
}
