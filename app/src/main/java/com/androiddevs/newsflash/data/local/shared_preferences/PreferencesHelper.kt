package com.androiddevs.newsflash.data.local.shared_preferences

interface PreferencesHelper {

    fun setLoggedIn()

    fun logout()

    fun getLoggedIn():Boolean
}