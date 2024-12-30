package com.example.composestabilityexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.composestabilityexamples.main_screen.MainScreen
import com.example.composestabilityexamples.ui.theme.ComposeStabilityExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStabilityExamplesTheme {
                MainScreen()
            }
        }
    }
}