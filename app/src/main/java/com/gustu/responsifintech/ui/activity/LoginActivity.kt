package com.gustu.responsifintech.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gustu.responsifintech.R
import com.gustu.responsifintech.model.Users
import com.gustu.responsifintech.room.UsersDatabase
import com.gustu.responsifintech.sharedpref.SharedPrefUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    lateinit var db: UsersDatabase
    lateinit var usersList: List<Users>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        db = UsersDatabase.getInstance(this)
        btLogin.setOnClickListener {
            if (etNIM.text.toString().isEmpty()) {
                etNIM.setError("Please Fill Out This Field")
            } else if (etPassword.text.toString().isEmpty()) {
                etPassword.setError("Please Fill Out This Field")
            } else {
                usersList = db.dao.login(etNIM.text.toString(), etPassword.text.toString())
                if (usersList.size > 0) {
                    SharedPrefUtil.saveBoolean("login", true)
                    SharedPrefUtil.saveString("nim", etNIM.text.toString())
                    SharedPrefUtil.saveString("pwd", etPassword.text.toString())
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
                else{
                    Toast.makeText(applicationContext,"Login gagal",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}