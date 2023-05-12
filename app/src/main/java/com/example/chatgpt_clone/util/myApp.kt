package com.example.chatgpt_clone.util

import android.app.Application
import com.example.chatgpt_clone.Model.Net.createApiService
import com.example.chatgpt_clone.Model.Repository.HomeRepository
import com.example.chatgpt_clone.Model.Repository.HomeRepositoryImpl
import com.example.chatgpt_clone.ui.home.HomeFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class myApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val myModule = module{
            single { createApiService() }
            single<HomeRepository> { HomeRepositoryImpl(get()) }
            viewModel{
                HomeFragmentViewModel(get())}
        }

        startKoin {
            androidContext(this@myApp)
            modules(myModule)
        }
    }
}