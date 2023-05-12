package com.example.chatgpt_clone.Model.data


import com.google.gson.annotations.SerializedName

data class CompletionRequesResponse(
    @SerializedName("max_tokens")
    var maxTokens: Int,
    @SerializedName("model")
    var model: String,
    @SerializedName("`prompt`")
    var prompt: String,
    @SerializedName("temperature")
    var temperature: Float = 0f,

)