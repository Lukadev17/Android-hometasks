package com.example.homework6.database

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class CarsRelatedToUsers (
    @Embedded val user: User,
    @Relation(
        parentColumn = "uid",
        entityColumn = "carownerid"
    )
    val cars : List<Car>
)