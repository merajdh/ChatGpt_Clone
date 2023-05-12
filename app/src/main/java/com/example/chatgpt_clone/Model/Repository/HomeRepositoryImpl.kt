package com.example.chatgpt_clone.Model.Repository

import com.example.chatgpt_clone.Model.Net.ApiService
import com.example.chatgpt_clone.Model.data.CompletionRequesResponse
import com.example.chatgpt_clone.Model.data.CompletionRespons
import com.google.gson.JsonObject

class HomeRepositoryImpl(private val apiService : ApiService):HomeRepository {
    override suspend fun getAnswer(question : String): CompletionRequesResponse {
        val jsonObject = JsonObject().apply {
            addProperty("question", question)
        }
        return apiService.getMessage(jsonObject)
    }
}