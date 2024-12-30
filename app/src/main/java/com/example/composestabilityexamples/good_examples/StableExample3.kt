package com.example.composestabilityexamples.good_examples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
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
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.stable3)
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