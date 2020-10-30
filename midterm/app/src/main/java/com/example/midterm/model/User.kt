package com.example.midterm.model


data class User(
    val firstname: String?,
    val lastname: String?,
    val skills : List<String>? = null
)
