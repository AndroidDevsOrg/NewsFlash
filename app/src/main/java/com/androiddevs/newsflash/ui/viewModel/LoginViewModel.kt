package com.androiddevs.newsflash.ui.viewModel

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.androiddevs.newsflash.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class LoginViewModel(private val activity: Activity): ViewModel() {
    fun createGoogleSignInRequest(): GoogleSignInClient {
        val googleSignInOption = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        return activity.let { GoogleSignIn.getClient(it,googleSignInOption) }
    }
}