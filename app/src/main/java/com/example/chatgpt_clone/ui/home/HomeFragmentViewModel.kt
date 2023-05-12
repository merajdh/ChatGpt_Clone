package com.example.chatgpt_clone.ui.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatgpt_clone.Model.Repository.HomeRepository
import com.example.chatgpt_clone.Model.data.CompletionRequesResponse
import com.example.chatgpt_clone.Model.data.CompletionRespons
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val homeRepository: HomeRepository): ViewModel() {

    val question = MutableLiveData("")

    fun postQuestion(questionEvent: (CompletionRequesResponse) -> Unit) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            Log.v("error", "Error -> " + throwable.message)
        } // view error
        viewModelScope.launch(coroutineExceptionHandler) {
            val result = homeRepository.getAnswer(question.value!!) // Answer server
            questionEvent(result) // Event Login to FragmentLogin
        }
    }

}