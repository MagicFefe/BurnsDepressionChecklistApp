package com.app.burnsdepressionchecklistapp.presentation.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val ColorPalette = lightColors(
    primary = Green500,
    primaryVariant = Green700,
    surface = Green500,
    background = Green500,
    onPrimary = Color.Black
)

@Composable
fun BurnsDepressionChecklistAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = ColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}