package com.gustu.responsifintech.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**Created by Gustu Maulana Firmansyah on 06,July,2021  gustumaulanaf@gmail.com **/
@Entity
class Users {
    @PrimaryKey(autoGenerate = false)
    var nim: String = ""

    @ColumnInfo(name = "password")
    var pwd: String = ""

    @ColumnInfo(name = "foto")
    var foto: String = ""

    @ColumnInfo(name = "jurusan")
    var jurusan: String = ""
}