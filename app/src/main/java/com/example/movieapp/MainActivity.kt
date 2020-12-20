package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import okhttp3.*
import java.io.IOException
import java.net.URL

// Declaring Main activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  recycleView = findViewById<RecyclerView>(R.id.recyclerView_main)



        //recycleView.setBackgroundColor(getColor(R.color.black))

        recycleView.layoutManager = LinearLayoutManager(this)


        fetchJson()
    }
// Fetching and Parsing Json File
    fun fetchJson(){
        println("Attempring to fetch")
// Declaring Request Link
        val url = "https://my-json-server.typicode.com/nikoloz14/movies-db/db"

        val client = OkHttpClient()
// Building request
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback{
// Getting Response from the link
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val  recycleView = findViewById<RecyclerView>(R.id.recyclerView_main)
// Parsing Recieved Data
                val gson = GsonBuilder().create()

                val moviesFeed = gson.fromJson(body, MoviesFeed:: class.java)


                runOnUiThread {
                    recycleView.adapter= MainAdapter(moviesFeed)
                }
            }
// In case Request Fails, Returning Error Message

            override fun onFailure(call: Call, e: IOException) {
               println("Failed Bro")
            }
        })
    }
}














