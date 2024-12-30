package com.example.composestabilityexamples.bad_examples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android.compose.recomposehighlighter.recomposeHighlighter
import com.example.composestabilityexamples.R

/**
 * StableExample5
 * Demonstrates instability caused by the use of a mutable property (`MutableList`)
 * within a `data class` without additional annotations or mechanisms to ensure stability.
 */

data class Items8(
    val items: MutableList<String> = mutableListOf("") // ❌ Unstable due to mutable property
)

@Composable
fun UnstableExample5(
    items: Items8,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.unstable5)
                onImageClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = items.items.joinToString())
    }
}