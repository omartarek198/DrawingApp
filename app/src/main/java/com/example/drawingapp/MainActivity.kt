package com.example.drawingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    var drawview : DrawView ?=null
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawview = findViewById(R.id.drawing_view)
        drawview!!.setBrushSize(20.toFloat())
    }
}