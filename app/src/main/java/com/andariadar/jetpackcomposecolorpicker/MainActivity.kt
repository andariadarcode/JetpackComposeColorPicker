package com.andariadar.jetpackcomposecolorpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorPicker()
        }
    }
}

@Composable
fun ColorPicker() {
    val colors = listOf(
        Color(0xfff9a825),
        Color(0xffff3d00),
        Color(0xff4caf50),
        Color(0xff9c27b0),
        Color(0xff2196f3))
    val currentColor = remember { mutableStateOf(colors[0]) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row {
            colors.forEach { color ->
                val isSelected = currentColor.value == color
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color)
                        .selectable(
                            selected = isSelected,
                            onClick = { currentColor.value = color })
                ) {
                    if (currentColor.value == color) {
                        Icon(imageVector = Icons.Filled.Done,
                            contentDescription = "Done",
                            tint = Color.White,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }

        Text(
            text = "TEXT",
            color = currentColor.value,
            fontSize = 27.sp)
    }
}