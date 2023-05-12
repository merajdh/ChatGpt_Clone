package com.example.chatgpt_clone.Model.data


import com.google.gson.annotations.SerializedName

data class CompletionRespons(
    @SerializedName("choices")
    var choices: List<Choice>,
    @SerializedName("created")
    var created: Int,
    @SerializedName("id")
    var id: String,
    @SerializedName("model")
    var model: String,
    @SerializedName("object")
    var obj: String,
    @SerializedName("usage")
    var usage: Usage
) {
    data class Choice(
        @SerializedName("finish_reason")
        var finishReason: String,
        @SerializedName("index")
        var index: Int,
        @SerializedName("message")
        var message: Message
    ) {
        data class Message(
            @SerializedName("content")
            var content: String,
            @SerializedName("role")
            var role: String
        )
    }

    data class Usage(
        @SerializedName("completion_tokens")
        var completionTokens: Int,
        @SerializedName("prompt_tokens")
        var promptTokens: Int,
        @SerializedName("total_tokens")
        var totalTokens: Int
    )
}