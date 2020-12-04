package com.example.homework6.database

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): User

    @Transaction
    @Query("SELECT * FROM User")
    fun getUsersWithCars(): List<CarsRelatedToUsers>

    @Insert()
    fun insertAll(vararg users: User)

    @Delete()
    fun delete(user: User)

    @Query("DELETE  FROM User")
    fun deleteData()
}