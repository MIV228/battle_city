package com.example.battlecity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.KeyEvent.*
import android.widget.FrameLayout
import android.widget.ImageView

var CELL_SIZE = 50
var VERTICAL_CELL_AMOUNT = 15
var HORIZONTAL_CELL_AMOUNT = 15
var VERTICAL_MAX_SIZE = CELL_SIZE + VERTICAL_CELL_AMOUNT
var HORIZONTAL_MAX_SIZE = CELL_SIZE + HORIZONTAL_CELL_AMOUNT

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val box = findViewById<FrameLayout>(R.id.box)
        box.layoutParams = FrameLayout.LayoutParams(VERTICAL_MAX_SIZE, HORIZONTAL_MAX_SIZE)

//        when(MotionEvent)
//        {
//            ACTION_UP -> move(Direction.UP)
//            ACTION_DOWN -> move(Direction.BOTTOM)
//
//        }

        val up = findViewById<ImageView>(R.id.up)
        up.setOnClickListener{ move(Direction.UP) }
        val left = findViewById<ImageView>(R.id.left)
        left.setOnClickListener{ move(Direction.LEFT) }
        val right = findViewById<ImageView>(R.id.right)
        right.setOnClickListener{ move(Direction.RIGHT) }
        val down = findViewById<ImageView>(R.id.down)
        down.setOnClickListener{ move(Direction.BOTTOM) }
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
        val myTank = findViewById<ImageView>(R.id.my_tank)
        val layoutParams = (myTank.layoutParams) as FrameLayout.LayoutParams
        when (direction) {
            Direction.UP -> {
//                val myTank = findViewById<ImageView>(R.id.my_tank)
                if (layoutParams.topMargin > 0) {
                    myTank.layoutParams
                }
                myTank.rotation = 0F
                (myTank.layoutParams as FrameLayout.LayoutParams).topMargin -= CELL_SIZE
            }
            Direction.BOTTOM -> {
//                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 180F
                (myTank.layoutParams as FrameLayout.LayoutParams).topMargin += CELL_SIZE
            }
            Direction.LEFT -> {
//                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 270F
                (myTank.layoutParams as FrameLayout.LayoutParams).leftMargin -= CELL_SIZE
            }
            Direction.RIGHT -> {
//                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 90F
                (myTank.layoutParams as FrameLayout.LayoutParams).leftMargin += CELL_SIZE
            }
        }
        val box = findViewById<FrameLayout>(R.id.box)
        box.removeView(myTank)
        box.addView(myTank)
    }
}