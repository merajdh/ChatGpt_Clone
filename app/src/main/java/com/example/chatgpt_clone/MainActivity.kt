package com.example.chatgpt_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.chatgpt_clone.databinding.ActivityMainBinding
import com.example.chatgpt_clone.ui.home.HomeFragment
import com.example.chatgpt_clone.ui.intro.IntroFragment
import java.util.*
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        transform(IntroFragment())
        Timer().schedule(3500) {
            transform(HomeFragment())
        }
    }

    private fun transform(fragment:Fragment){
        val transform = supportFragmentManager.beginTransaction()
        transform.replace(R.id.FrameLayout , fragment)
        transform.commit()
    }
}