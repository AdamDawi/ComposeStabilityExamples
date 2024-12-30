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
 * UnstableExample4
 * - Demonstrates instability caused by a mutable property (`var`).
 * - Even if the type itself is stable, the mutability of the property causes recompositions.
 */
data class Items7(
    var title: String // ❌ Mutable property causes instability
)

@Composable
fun UnstableExample4(
    items: Items7,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.unstable4)
                onImageClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = items.title)
    }
}