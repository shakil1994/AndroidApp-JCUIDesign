package com.blackbirds.jccanvas

import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blackbirds.jccanvas.ChartUtils.DEFAULT_CHART_HEIGHT
import com.blackbirds.jccanvas.ChartUtils.DEFAULT_CHART_PADDING
import kotlin.math.roundToInt

class ChartsActivity : ComponentActivity() {

    private val viewModel by viewModels<ChartsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                //LineChart(viewModel.chartData)
                LazyColumn(verticalArrangement = Arrangement.spacedBy(100.dp)) {
                    itemsIndexed(viewModel.chartData2){ index, item ->
                        Text(text = "Chart ${index + 1}")
                        LineChart(data = item,
                            chartColor = ChartUtils.randomDarkColor())
                    }
                }
            }
        }
    }
}

@Composable
fun LineChart(data: List<ChartData>, chartColor : Color) {

    val height = DEFAULT_CHART_HEIGHT
    val xAxisPadding = DEFAULT_CHART_PADDING
    val yAxisPadding = DEFAULT_CHART_PADDING

    val xAxisData = data.map { it.x }
    val yAxisData = data.map { it.y }

    val offsetList = remember {
        mutableListOf<Offset>()
    }

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(DEFAULT_CHART_PADDING)
    ) {
        val gridHeight = height.toPx() - yAxisPadding.toPx() * 3
        val gridWidth = size.width

        val maxPointSize = yAxisData.distinct().size

        val absMaxYPoint = yAxisData.maxByOrNull {
            it.toFloat().roundToInt()
        } ?: 0

        val verticalStepper = (absMaxYPoint.toInt() / maxPointSize).toFloat()

        val yAxisLabelsList = mutableListOf<String>()
        for (i in 0..maxPointSize) {
            val interval = (i * verticalStepper).roundToInt()
            yAxisLabelsList.add(interval.toString())
        }

        val xAxisSpacing = (gridWidth - xAxisPadding.toPx()) / (maxPointSize - 1)
        val yAxisSpacing = gridHeight / (yAxisLabelsList.size - 1)

        offsetList.clear()

        for (i in 0 until maxPointSize) {
            val x = (i * xAxisSpacing) + xAxisPadding.toPx()
            val y = gridHeight - (yAxisSpacing * (yAxisData[i].toFloat() / verticalStepper))

            offsetList.add(
                Offset(x, y)
            )
        }

        for (i in 0 until maxPointSize) {
            val xOffset = (xAxisSpacing * i) + xAxisPadding.toPx()
            drawLine(
                color = Color.Gray,
                start = Offset(xOffset, 0f),
                end = Offset(xOffset, gridHeight),
                strokeWidth = 2f
            )
        }

        for (i in 0 until yAxisLabelsList.size) {
            val offsetX = xAxisPadding.toPx()
            val offsetY = gridHeight - (yAxisSpacing * i)
            drawLine(
                color = Color.Gray,
                start = Offset(offsetX, offsetY),
                end = Offset(gridWidth, offsetY),
                strokeWidth = 2f
            )
        }

        for (i in 0 until maxPointSize) {
            val xOffset = (xAxisSpacing * i) + xAxisPadding.toPx()
            drawContext.canvas.nativeCanvas.drawText(
                xAxisData[i],
                xOffset,
                size.height,
                Paint().apply {
                    color = Color.Gray.toArgb()
                    textAlign = Paint.Align.CENTER
                    textSize = 18.sp.toPx()
                }
            )
        }

        for (i in 0 until yAxisLabelsList.size) {
            drawContext.canvas.nativeCanvas.drawText(
                yAxisLabelsList[i],
                0f,
                gridHeight - (yAxisSpacing * i),
                Paint().apply {
                    color = Color.Gray.toArgb()
                    textAlign = Paint.Align.CENTER
                    textSize = 18.sp.toPx()
                }
            )
        }

        offsetList.forEachIndexed { index, offset ->
            drawCircle(
                color = chartColor,
                radius = 5.dp.toPx(),
                center = offset
            )
        }

        drawPoints(
            points = offsetList,
            color = chartColor,
            pointMode = PointMode.Polygon,
            strokeWidth = 4f
        )

        val gradientPath = Path().apply {
            moveTo(xAxisPadding.toPx(), gridHeight)

            for (i in 0 until maxPointSize) {
                lineTo(offsetList[i].x, offsetList[i].y)
            }

            lineTo(gridWidth, gridHeight)
            close()
        }

        drawPath(
            path = gradientPath,
            brush = Brush.verticalGradient(
                colors = listOf(chartColor, Color.Transparent)
            )
        )
    }
}