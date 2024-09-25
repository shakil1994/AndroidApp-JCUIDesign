package com.blackbirds.jccanvas

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

object ChartUtils {
    val DEFAULT_CHART_HEIGHT = 340.dp
    val DEFAULT_CHART_PADDING = 18.dp

    fun randomDarkColor(): Color{
        return Color(
            red = Random.nextInt(150), // Red value between 0 and 150
            green = Random.nextInt(150), // Green value between 0 and 150
            blue = Random.nextInt(150), // Blue value between 0 and 150
        )
    }
}