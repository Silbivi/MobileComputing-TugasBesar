package com.silvia.cookieandmilk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Pesan : AppCompatActivity() {
    private val shareprefile = "KotlinSharedPreference"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesan)
        title="Order Cookies"

        val inputpembeli = findViewById<EditText>(R.id.editpembeli)
        val inputnama = findViewById<EditText>(R.id.editnama)
        val inputjumlah = findViewById<EditText>(R.id.editjumlah)
        val outputpembeli = findViewById<TextView>(R.id.showpembeli)
        val outputnama = findViewById<TextView>(R.id.shownama)
        val outputjumlah = findViewById<TextView>(R.id.showjumlah)
        val outputtotal = findViewById<TextView>(R.id.showtotal)

        val btnorder = findViewById<Button>(R.id.order)
        val btnview = findViewById<Button>(R.id.view)
        val btnclear = findViewById<Button>(R.id.clear)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(shareprefile,Context.MODE_PRIVATE)

        btnorder.setOnClickListener(View.OnClickListener {
            val pembeli:String = inputpembeli.text.toString()
            val nama:String = inputnama.text.toString()
            val jumlah:Int = Integer.parseInt(inputjumlah.text.toString())
            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("pembeli_key",pembeli)
            editor.putString("nama_key",nama)
            editor.putInt("jumlah_key",jumlah)
            editor.putInt("total_key",jumlah*15000)
            editor.apply()
            editor.commit()
        })

        btnview.setOnClickListener{
            val sharedpembelivalue = sharedPreferences.getString("pembeli_key","defaultname")
            val sharednamavalue = sharedPreferences.getString("nama_key","defaultname")
            val sharedjumlahvalue = sharedPreferences.getInt("jumlah_key",0)
            val sharedtotalvalue = sharedPreferences.getInt("total_key",15000)
            if (sharedpembelivalue.equals("defaultname")&&sharednamavalue.equals("defaultname")&&sharedjumlahvalue.equals(0)&&sharedtotalvalue.equals(15000)){
                outputpembeli.setText("default pembeli:${sharedpembelivalue.toString()}")
                outputnama.setText("default nama:${sharednamavalue.toString()}")
                outputjumlah.setText("default jumlah:${sharedjumlahvalue}")
                outputtotal.setText("default total:${sharedtotalvalue}")
            }else{
                outputpembeli.setText(sharedpembelivalue).toString()
                outputnama.setText(sharednamavalue).toString()
                outputjumlah.setText(sharedjumlahvalue.toString())
                outputtotal.setText(sharedtotalvalue.toString())
            }
        }

        btnclear.setOnClickListener(View.OnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            outputpembeli.setText("").toString()
            outputnama.setText("").toString()
            outputjumlah.setText("".toString())
            outputtotal.setText("".toString())
        })
    }
}