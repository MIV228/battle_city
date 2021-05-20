package com.example.battlecity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
       when (keyCode) {
           KEYCODE_DPAD_UP -> move(Direction.UP)
           KEYCODE_DPAD_DOWN -> move(Direction.DOWN)
           KEYCODE_DPAD_LEFT -> move(Direction.LEFT)
           KEYCODE_DPAD_RIGHT -> move(Direction.RIGHT)
       }
        return super.onKeyDown(keyCode, event)
    }

    private fun move(direction: Direction) {

    }
}