package com.example.uielementspart2.models

class Album(var id: Int = 0, var title: String, var date: String){
    override fun toString(): String {
        return "TITLE: $title, DATE: $date"
    }
}