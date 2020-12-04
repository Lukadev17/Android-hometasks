package com.example.midterm2.model

data class User(
    val firstname: String?,
    val lastname: String?,
    val skills : List<String>? = null
)
