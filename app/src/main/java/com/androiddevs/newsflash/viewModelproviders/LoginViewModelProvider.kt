package com.androiddevs.newsflash.viewModelproviders

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.newsflash.ui.viewModel.LoginViewModel

class LoginViewModelProvider(private val activity: Activity): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(activity) as T
    }
}