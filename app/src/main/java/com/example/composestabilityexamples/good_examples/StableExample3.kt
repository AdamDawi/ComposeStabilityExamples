package com.example.composestabilityexamples.good_examples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android.compose.recomposehighlighter.recomposeHighlighter
import com.example.composestabilityexamples.R

/**
 * StableExample3
 * - Demonstrates stability using the `@Immutable` annotation.
 * - Guarantees that the class is immutable, even if it contains a standard `List`.
 */
@Immutable
class Items2(
    val items: List<String> // ✅ Immutable due to @Immutable annotation
)

@Composable
fun StableExample3(
    items: Items2,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.stable3)
                onImageClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = items.items.joinToString())
    }
}