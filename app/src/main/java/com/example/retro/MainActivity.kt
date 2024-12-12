package com.example.retro

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    //var dataArrayList = ArrayList<MarsPhoto?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<ListView>(R.id.listphoto)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://android-kotlin-fun-mars-server.appspot.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val lists = retrofit.getMarsPhoto()
            val ada = listAdapter(this@MainActivity, lists.body())
            runOnUiThread {
               list.adapter = ada
            }
        }



    }
}