package com.example.drawingapp

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.graphics.*
import android.util.TypedValue
import android.view.MotionEvent

class DrawView (context: Context, attrs: AttributeSet): View(context,attrs) {
    private var drawPath : CustomPath?=null
    private var CanvasBitmap:Bitmap ?=null
    private var drawPaint:Paint?=null
    private var BrushSize:Float = 0.toFloat()
    private var canvaspaint:Paint?=null
    private var color = Color.BLACK
    private var canvas:Canvas?=null
    private var paths = ArrayList<CustomPath>()
    init{
        MakeActors()
    }

    private fun MakeActors(){
        drawPaint= Paint()
        drawPath=CustomPath(color, BrushSize)
        drawPaint!!.color=color
        drawPaint!!.style= Paint.Style.STROKE
        drawPaint!!.strokeCap=Paint.Cap.ROUND
        drawPaint!!.strokeJoin=Paint.Join.ROUND
        canvaspaint= Paint(Paint.DITHER_FLAG)

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        CanvasBitmap = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888)
        canvas= Canvas(CanvasBitmap!!)

    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)
        canvas?.drawBitmap(CanvasBitmap!!,0f,0f,canvaspaint)

        for (i in paths)
    {
        drawPaint!!.strokeWidth = i!!.BrushThickness
        drawPaint!!.color = i!!.color
        canvas?.drawPath(i!!,drawPaint!!)
    }


        if (!drawPath!!.isEmpty)
        {
            drawPaint!!.strokeWidth = drawPath!!.BrushThickness
            drawPaint!!.color = drawPath!!.color
            canvas?.drawPath(drawPath!!,drawPaint!!)
        }

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val x = event?.x
        val y = event?.y

        when(event?.action)
        {
            MotionEvent.ACTION_DOWN->{
                drawPath!!.color = color
                drawPath!!.BrushThickness = BrushSize
                drawPath!!  .reset()
                drawPath!!.moveTo(x!!,y!!+30)
            }
            MotionEvent.ACTION_MOVE->{
                drawPath!!.lineTo(x!!,y!!+30)
            }

            MotionEvent.ACTION_UP->{
                paths.add(drawPath!!)
                drawPath = CustomPath(color,BrushSize)
            }


            else -> return false


        }
        invalidate()

        return true


    }

    fun setBrushSize(size:Float)
    {
        BrushSize=TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,size,resources.displayMetrics)
        drawPath!!.BrushThickness = BrushSize
    }
    internal inner class CustomPath (var color:Int,
                                     var BrushThickness:Float) : Path ( ){

    }
}


