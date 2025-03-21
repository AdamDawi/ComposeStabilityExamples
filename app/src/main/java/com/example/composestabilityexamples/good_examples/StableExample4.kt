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
import androidx.compose.ui.Modifier
import com.example.android.compose.recomposehighlighter.recomposeHighlighter
import com.example.composestabilityexamples.R
import kotlinx.collections.immutable.ImmutableList

/**
 * StableExample4
 * - Demonstrates stability with a data class, which provides `equals` and `hashCode`.
 * - All properties are immutable or use stable types, ensuring composable stability.
 */
data class Items5(
    val title: String, // ✅ Immutable primitive type
    val items: ImmutableList<String>, // ✅ ImmutableList
    val footnote: FootNote // ✅ Immutable data class
)

data class FootNote(
    val footnote: String // ✅ Immutable primitive type
)

@Composable
fun StableExample4(
    items: Items5,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.stable4)
                onImageClick()
            },
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = items.title)
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null
        )
    }
}