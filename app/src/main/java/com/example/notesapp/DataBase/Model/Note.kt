package com.example.notesapp.DataBase.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
        @PrimaryKey(autoGenerate = true)
        val title: String,
        val time: String,
        val description: String
)