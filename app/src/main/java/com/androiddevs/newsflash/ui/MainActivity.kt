package com.androiddevs.newsflash.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.androiddevs.newsflash.R
import com.androiddevs.newsflash.ui.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openLoginFragment()
    }

    private fun openLoginFragment() {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_main, LoginFragment())
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
