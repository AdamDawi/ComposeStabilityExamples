package com.example.composestabilityexamples.good_examples

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.android.compose.recomposehighlighter.recomposeHighlighter
import com.example.composestabilityexamples.R
import kotlinx.collections.immutable.ImmutableList

/**
 * StableExample2
 * - Uses an `ImmutableList`, which is stable by design.
 * - Guarantees immutability and avoids unnecessary recompositions.
 */
@Composable
fun StableExample2(
    items: ImmutableList<String>, // ✅ ImmutableList is immutable
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.stable2)
                onImageClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = items.joinToString())
    }
}