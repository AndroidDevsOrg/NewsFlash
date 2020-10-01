package com.androiddevs.newsflash.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NewsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long
)