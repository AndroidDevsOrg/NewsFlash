package com.androiddevs.newsflash.data.local.shared_preferences

import android.content.SharedPreferences
import javax.inject.Inject

class PreferencesHelperImpl @Inject constructor(private val sharedPreferences: SharedPreferences) :
    PreferencesHelper {

    companion object {
        const val LOGGEDIN = "LOGGED_IN"
    }

    override fun setLoggedIn() {
        sharedPreferences.edit().putBoolean(LOGGEDIN, true).apply()
    }

    override fun logout() {
        sharedPreferences.edit().clear().apply()
    }

    override fun getLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(LOGGEDIN, false)
    }

}