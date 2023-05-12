package com.example.chatgpt_clone.Model.Net

import com.example.chatgpt_clone.Model.data.CompletionRequesResponse
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

const val BASE_URL = "https://api.openai.com/v1/completions/"
const val API_KEY = "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"
interface ApiService {

    @Headers("Content-Type:" , "application/json")
    @POST("/v1/Completion")
    suspend fun getMessage(@Body jsonObject: JsonObject) : CompletionRequesResponse
}
fun createApiService(): ApiService {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {
            val oldRequest = it.request()
            val newRequest = oldRequest.newBuilder()
            newRequest.addHeader("Authorization" , "Bearer ${API_KEY}")
            newRequest.method(oldRequest.method, oldRequest.body)

            return@addInterceptor it.proceed(newRequest.build())
        }
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(ApiService::class.java)
}

