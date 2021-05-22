package com.example.battlecity

import android.app.Activity
import android.content.Context
import android.view.View

import android.widget.FrameLayout

class GridDrawer(val context: Context) {
    fun drawGrid() {
        val box = (context as Activity).findViewById<FrameLayout>(R.id.box)
        drawHorizontalLines(box)
        drawVerticalLines(box)
    }

    private fun drawVerticalLines(box: FrameLayout) {
        var topMargin = 0
        while (topMargin <= box.layoutParams.width) {
            val horizontalLine = View(context)
            val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1)
            topMargin += 50
            layoutParams.topMargin = topMargin
            horizontalLine.layoutParams = layoutParams
            horizontalLine.setBackgroundColor(context.resources.getColor(android.R.color.white))
            box.addView(horizontalLine)
        }
    }

    private fun drawHorizontalLines(box: FrameLayout) {

    }

}