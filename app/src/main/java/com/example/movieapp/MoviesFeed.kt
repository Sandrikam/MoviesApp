package com.example.movieapp

import java.net.URL
import java.util.*

class MoviesFeed (val films: List<Film>) {

}

class Film(val id: Int, val title: String, var date: Date, var language: String, var seasons: Int,
           var imageUrl: URL,val cast: cast )
// passsing cast json infromation into film jason
class cast (val id: Int, val fullName: String, val role: String, val imageUrl: URL )