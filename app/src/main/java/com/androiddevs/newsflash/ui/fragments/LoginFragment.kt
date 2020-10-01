package com.androiddevs.newsflash.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.androiddevs.newsflash.R
import com.androiddevs.newsflash.constants.RC_SIGN_IN
import com.androiddevs.newsflash.ui.viewModel.LoginViewModel
import com.androiddevs.newsflash.viewModelproviders.LoginViewModelProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private var googleSignInClient: GoogleSignInClient? = null

    private lateinit var loginViewModel: LoginViewModel

    private lateinit var auth: FirebaseAuth

    companion object {
        const val TAG = "LoginFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViewModel()
        createGoogleSignInRequest()
        setClickListeners()
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            //TODO: Navigate to home Screen
        }
    }

    private fun initializeViewModel() {
        loginViewModel = ViewModelProvider(
            this,
            LoginViewModelProvider(requireActivity())
        ).get(LoginViewModel::class.java)
    }

    private fun createGoogleSignInRequest() {
        googleSignInClient = loginViewModel.createGoogleSignInRequest()
    }

    private fun setClickListeners() {
        googleButton.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient?.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                //TODO: Navigate to homeScreen
                Log.e(TAG, "Google Sign In SuccessFull")
            } else {
                Log.e(TAG, "Google Sign In failed")
            }
        }
    }
}