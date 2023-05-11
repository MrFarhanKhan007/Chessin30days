package com.example.chessin30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.chessin30days.ui.theme.ChessApp
import com.example.woofapp.ui.theme.Chessin30daysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        WindowCompat.setDecorFitsSystemWindows(window,false)
//        WindowInsetsControllerCompat(window, window.decorView).apply {
//            hide(WindowInsetsCompat.Type.statusBars())
//            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
//        }
        setContent {
            Chessin30daysTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChessApp()
                }
            }
        }
    }
}

@Preview
@Composable
fun LightPreview() {
    Chessin30daysTheme(darkTheme = false) {
        ChessApp()
    }
}


@Preview(showBackground = false)
@Composable
fun DarkPreview() {
    Chessin30daysTheme(darkTheme = true) {
        ChessApp()
    }
}