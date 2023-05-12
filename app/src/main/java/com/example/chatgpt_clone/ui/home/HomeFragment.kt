package com.example.chatgpt_clone.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chatgpt_clone.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val viewModel: HomeFragmentViewModel by viewModel()
        binding.mouduleOneHome.sendMessage.setOnClickListener {
            viewModel.question.value = binding.mouduleOneHome.EdtSearch.text.toString()
            viewModel.postQuestion {

            }
        }
        return binding.root
    }
}