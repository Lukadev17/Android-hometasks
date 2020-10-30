package com.example.retrofit_cast_api.model

data class CastResult(
    val Characters: List<Character>
)

data class Character(
    val char_id: Long,
    val name: String,
    val birthday: String,
    val nickname: String
)