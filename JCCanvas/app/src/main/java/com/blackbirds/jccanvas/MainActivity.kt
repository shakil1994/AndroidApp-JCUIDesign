package com.blackbirds.jccanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.blackbirds.jccanvas.ui.theme.JCCanvasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JCCanvasTheme {
                Surface {
                    DrawPath()
                }
            }
        }
    }
}

@Composable
fun DrawLine(){
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawLine(start = Offset(50f, 850f),
            end = Offset(800f, 850f),
            color = Color.Blue,
            alpha = 1f,
            strokeWidth = 8f,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun DrawPath(){
    Canvas(modifier = Modifier.fillMaxSize()) {
        val path = Path().apply {
            moveTo(x = 100f, y = 1000f)
            lineTo(x = 500f, y = 200f)
            lineTo(x = 950f, y = 1000f)
            close()
        }
        drawPath(
            path = path,
            color = Color.Blue,
            alpha = 1f,
            style = Stroke(4f, cap = StrokeCap.Round)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DrawLinePreview(){
    DrawLine()
}

@Preview(showBackground = true)
@Composable
fun DrawPathPreview(){
    DrawPath()
}