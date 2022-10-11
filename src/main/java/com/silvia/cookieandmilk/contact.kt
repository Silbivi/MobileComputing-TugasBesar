package com.silvia.cookieandmilk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import android.content.Intent
import kotlinx.android.synthetic.main.activity_contact.*

class contact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        title="Contact Cookies"
        btnemail.setOnClickListener{
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("cookieschocolatechip@gmail.com"))
            intent.type = "message/rfc822"
            startActivity(intent)
        }

        btntlp.setOnClickListener{
            val tlp : Intent = Uri.parse("tel:0224242990").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(tlp)
        }

        btnlokasi.setOnClickListener{
            val lokasi: Intent = Uri.parse(
                "geo:0,0?q=Jl.+Kb.+Gedang"
            ).let { location ->
                Intent(Intent.ACTION_VIEW, location)
            }
            startActivity(lokasi)
        }
    }
}