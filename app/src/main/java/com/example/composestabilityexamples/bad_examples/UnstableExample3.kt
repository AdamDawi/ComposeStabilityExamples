package com.example.composestabilityexamples.bad_examples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.android.compose.recomposehighlighter.recomposeHighlighter
import com.example.composestabilityexamples.R

/**
 * UnstableExample3
 * - Demonstrates instability due to a class holding a mutable `List`.
 * - Even though the class itself might not change, its content can, causing recompositions.
 */
data class Items3(
    val items: List<String> // ❌ Standard List causes instability
)

@Composable
fun UnstableExample3(
    items: Items3,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.unstable3)
                onImageClick()
            },
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = items.items.joinToString())
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
}