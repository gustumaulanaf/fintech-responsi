package com.gustu.responsifintech.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gustu.responsifintech.model.Users


/**Created by Gustu Maulana Firmansyah on 06,July,2021  gustumaulanaf@gmail.com **/
@Database(entities = [Users::class], version = 1, exportSchema = false)
abstract class UsersDatabase : RoomDatabase() {
    abstract var dao: UsersDAO

    companion object {
        internal var INSTANCE: UsersDatabase? = null
        fun getInstance(context: Context): UsersDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, UsersDatabase::class.java, "users-db"
                ).allowMainThreadQueries().build()
            }
            return INSTANCE!!
        }
    }

    fun destroyInstance() {
        INSTANCE = null
    }
}