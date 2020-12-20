package com.example.movieapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class MainAdapter:RecyclerView.Adapter<CustomViewHolder>(){

    val movieTitle = listOf("First", "Second", "Third")
    // number of items
    override fun getItemCount(): Int {

        return 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
       //Creating View
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.movie_row, parent, false)


        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val movieTitle = movieTitle.get(position)
        //holder.view.
    }
}

class CustomViewHolder(val view:View): RecyclerView.ViewHolder(view){
    val movieTitle: TextView = view.findViewById(R.id.textView_movieTitle)

}