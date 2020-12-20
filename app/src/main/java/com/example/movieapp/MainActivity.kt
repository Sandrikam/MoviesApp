package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import java.io.IOException
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  recycleView = findViewById<RecyclerView>(R.id.recyclerView_main)



        //recycleView.setBackgroundColor(getColor(R.color.black))

        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter= MainAdapter()

        fetchJson()
    }

    fun fetchJson(){
        println("Attempring to fetch")

        val url = "https://my-json-server.typicode.com/nikoloz14/movies-db/db"

        val client = OkHttpClient()

        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback{

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)
            }

            override fun onFailure(call: Call, e: IOException) {
               println("Failed Bro")
            }
        })
    }
}














