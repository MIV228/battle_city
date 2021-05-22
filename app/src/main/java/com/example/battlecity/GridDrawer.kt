package com.example.battlecity

import android.app.Activity
import android.content.Context
import android.view.View

import android.widget.FrameLayout

class GridDrawer(private val context: Context) {
    fun drawGrid() {
        val box = (context as Activity).findViewById<FrameLayout>(R.id.box)
        drawHorizontalLines(box)
        drawVerticalLines(box)
    }

    private fun drawVerticalLines(box: FrameLayout) {
        var topMargin = 0
        while (topMargin <= box.layoutParams.height) {
            val horizontalLine = View(context)
            val layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, 1)
            topMargin += CELL_SIZE
            layoutParams.topMargin = topMargin
            horizontalLine.layoutParams = layoutParams
            horizontalLine.setBackgroundColor(context.resources.getColor(android.R.color.white))
            box.addView(horizontalLine)
        }
    }

    private fun drawHorizontalLines(box: FrameLayout) {
        var leftMargin = 0
        while (leftMargin <= box.layoutParams.width) {
            val verticalLine = View(context)
            val layoutParams = FrameLayout.LayoutParams( 1, FrameLayout.LayoutParams.MATCH_PARENT)
            leftMargin += CELL_SIZE
            layoutParams.leftMargin = leftMargin
            verticalLine.layoutParams = layoutParams
            verticalLine.setBackgroundColor(context.resources.getColor(android.R.color.white))
            box.addView(verticalLine)
        }
    }

}