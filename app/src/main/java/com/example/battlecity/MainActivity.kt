package com.example.battlecity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.KeyEvent.*
import android.widget.FrameLayout
import android.widget.ImageView

const val CELL_SIZE = 50
const val VERTICAL_CELL_AMOUNT = 38
const val HORIZONTAL_CELL_AMOUNT = 38
const val VERTICAL_MAX_SIZE = CELL_SIZE + VERTICAL_CELL_AMOUNT
const val HORIZONTAL_MAX_SIZE = CELL_SIZE + HORIZONTAL_CELL_AMOUNT

class MainActivity : AppCompatActivity() {

    private val GridDrawer by lazy {
        GridDrawer(this)
    }

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.settings, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_settings -> {
                GridDrawer.drawGrid()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
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
                (myTank.layoutParams as FrameLayout.LayoutParams).topMargin -= CELL_SIZE
            }
            Direction.BOTTOM -> {
                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 180F
                (myTank.layoutParams as FrameLayout.LayoutParams).topMargin += CELL_SIZE
            }
            Direction.LEFT -> {
                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 270F
                (myTank.layoutParams as FrameLayout.LayoutParams).leftMargin -= CELL_SIZE
            }
            Direction.RIGHT -> {
                val myTank = findViewById<ImageView>(R.id.my_tank)
                myTank.rotation = 90F
                (myTank.layoutParams as FrameLayout.LayoutParams).leftMargin += CELL_SIZE
            }
        }
        val myTank = findViewById<ImageView>(R.id.my_tank)
        val box = findViewById<FrameLayout>(R.id.box)
        box.removeView(myTank)
        box.addView(myTank)
    }
}