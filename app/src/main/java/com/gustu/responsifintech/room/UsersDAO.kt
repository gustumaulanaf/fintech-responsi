package com.gustu.responsifintech.room

import androidx.room.Dao
import androidx.room.Query
import com.gustu.responsifintech.model.Users


/**Created by Gustu Maulana Firmansyah on 06,July,2021  gustumaulanaf@gmail.com **/
@Dao
interface UsersDAO {
    @Query("SELECT * FROM Users WHERE nim LIKE :nim AND password LIKE :pwd")
    fun login(nim: String, pwd: String): List<Users>

}