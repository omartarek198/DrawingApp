package com.example.drawingapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    var drawview : DrawView ?=null
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawview = findViewById(R.id.drawing_view)
        drawview!!.setBrushSize(20.toFloat())
    }



    fun showBrushesDialog(view: View) {
        val brushDialog= Dialog(this)
        brushDialog.setContentView(R.layout.dialog_brush_size)
        brushDialog.setTitle("Select Size")
        val smallbrush:ImageButton = brushDialog.findViewById(R.id.small)
        val mediumbrush:ImageButton = findViewById(R.id.medium  )
        val largebrush:ImageButton = findViewById(R.id.large  )
        brushDialog.show()
        smallbrush.setOnClickListener()
        {
            drawview!!.setBrushSize(10.toFloat())
            brushDialog.dismiss()

        }
        mediumbrush.setOnClickListener()
        {
            drawview!!.setBrushSize(10.toFloat())
            brushDialog.dismiss()

        }
        largebrush.setOnClickListener()
        {
            drawview!!.setBrushSize(10.toFloat())
            brushDialog.dismiss()

        }

    }

}