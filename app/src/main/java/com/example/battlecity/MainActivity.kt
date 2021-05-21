package com.example.battlecity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.*
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        when(MotionEvent)
//        {
//            ACTION_UP -> move(Direction.UP)
//            ACTION_DOWN -> move(Direction.BOTTOM)
//
//        }
        val up = findViewById<ImageView>(R.id.up)
        up.setOnTouchListener{ view: View, direction: MotionEvent? -> move(Direction.UP) }
        val left = findViewById<ImageView>(R.id.left)
        left.setOnTouchListener{ view: View, direction: MotionEvent? -> move(Direction.LEFT) }
        val right = findViewById<ImageView>(R.id.right)
        right.setOnTouchListener{ view: View, direction: MotionEvent? -> move(Direction.RIGHT) }
        val down = findViewById<ImageView>(R.id.down)
        down.setOnTouchListener{ view: View, direction: MotionEvent? -> move(Direction.BOTTOM) }
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KEYCODE_DPAD_UP -> move(Direction.UP)
            KEYCODE_DPAD_DOWN -> move(Direction.BOTTOM)
            KEYCODE_DPAD_LEFT -> move(Direction.LEFT)
            KEYCODE_DPAD_RIGHT -> move(Direction.RIGHT)
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun move(direction: Direction) {
        when (direction) {
            Direction.UP -> {
                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 0F
                (myTank.layoutParams as FrameLayout.LayoutParams).topMargin -= 50
            }
            Direction.BOTTOM -> {
                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 180F
                (myTank.layoutParams as FrameLayout.LayoutParams).topMargin += 50
            }
            Direction.LEFT -> {
                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 270F
                (myTank.layoutParams as FrameLayout.LayoutParams).leftMargin -= 50
            }
            Direction.RIGHT -> {
                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 90F
                (myTank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
            }
        }
        val myTank = findViewById<ImageView>(R.id.my_tank)
        val box = findViewById<FrameLayout>(R.id.box)
        box.removeView(myTank)
        box.addView(myTank)
    }
}