package com.silvia.cookieandmilk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="e-Menu Cookies"

        btnorder.setOnClickListener(){
            intent = Intent(this, Pesan::class.java)
            startActivity(intent)
        }
        btnmenu.setOnClickListener(){
            intent = Intent(this, menu::class.java)
            startActivity(intent)
        }
        btnreview.setOnClickListener(){
            intent = Intent(this, review::class.java)
            startActivity(intent)
        }
        btncontact.setOnClickListener(){
            intent = Intent(this, contact::class.java)
            startActivity(intent)
        }
    }
}