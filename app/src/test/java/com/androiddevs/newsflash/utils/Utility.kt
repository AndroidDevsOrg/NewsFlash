package com.androiddevs.newsflash.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.nio.charset.Charset


inline fun <reified T> loadModelFromResource(classLoader: ClassLoader, string: String): T{
    return Gson().fromJson<T>(loadJSONFromAsset(classLoader, string))
}

inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object: TypeToken<T>() {}.type)

fun loadJSONFromAsset(classLoader: ClassLoader,string: String): String {

    var json: String = ""
    try {
        val `is` = classLoader.getResourceAsStream(string)
        val size = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()
        json = String(buffer, Charset.forName("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
    }

    return json
}