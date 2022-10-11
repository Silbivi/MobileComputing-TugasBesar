package com.silvia.cookieandmilk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class review : AppCompatActivity() {
    private lateinit var textView: TextView
    private var requestQueue:RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        title="Review Cookies"
        textView=findViewById(R.id.txtviewresult)
        requestQueue = Volley.newRequestQueue(this)
            jsonparse()

    }

    private fun jsonparse(){
        val url = "https://my-json-server.typicode.com/Silbivi/MobileComputing-TugasBesar/db"
        val request = JsonObjectRequest(Request.Method.GET, url, null, Response.Listener { response ->
            try {
                val jsonArray = response.getJSONArray("employees")
                for (i in 0 until jsonArray.length()) {
                    val employee = jsonArray.getJSONObject(i)
                    val nama = employee.getString("nama")
                    val rate = employee.getString("rate")
                    val nilai = employee.getString("nilai")
                    textView.append("$nama\n$rate\n$nilai\n\n")
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }, Response.ErrorListener { error -> error.printStackTrace() })
        requestQueue?.add(request)
    }
}