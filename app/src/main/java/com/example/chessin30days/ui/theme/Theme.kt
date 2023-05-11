package com.example.woofapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.example.Chessin30days.ui.theme.Cyan700
import com.example.Chessin30days.ui.theme.Cyan900
import com.example.Chessin30days.ui.theme.Green100
import com.example.Chessin30days.ui.theme.Green50
import com.example.Chessin30days.ui.theme.Grey100
import com.example.Chessin30days.ui.theme.Grey50
import com.example.Chessin30days.ui.theme.Grey700
import com.example.Chessin30days.ui.theme.Grey900
import com.example.Chessin30days.ui.theme.White

private val DarkColorPalette = darkColorScheme(
    background = Cyan900,
    surface = Cyan700,
    onSurface = White,
    primary = Grey900,
    onPrimary = White,
    secondary = Grey100
)

private val LightColorPalette = lightColorScheme(
    background = Green100,
    surface = Green50,
    onSurface = Grey900,
    primary = Grey50,
    onPrimary = Grey900,
    secondary = Grey700,
)

@Composable
fun Chessin30daysTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colors,
        typography = MaterialTheme.typography,
        content = content
    )
}