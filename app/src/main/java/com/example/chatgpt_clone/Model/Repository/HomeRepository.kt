package com.example.chatgpt_clone.Model.Repository

import com.example.chatgpt_clone.Model.data.CompletionRequesResponse

interface HomeRepository {
     suspend fun getAnswer(question : String): CompletionRequesResponse
}