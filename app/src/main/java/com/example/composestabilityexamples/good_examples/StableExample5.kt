package com.example.composestabilityexamples.good_examples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android.compose.recomposehighlighter.recomposeHighlighter
import com.example.composestabilityexamples.R

/**
 * StableExample5
 * - Demonstrates stability using the `@Stable` annotation.
 * - Ensures that recompositions occur only when explicitly notified, even if a mutable property exists.
 */
@Stable
data class Items6(
    val items: MutableList<String> = mutableListOf("") // ✅ Stable due to @Stable annotation
)

@Composable
fun StableExample5(
    items: Items6,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.stable5)
                onImageClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = items.items.joinToString())
    }
}