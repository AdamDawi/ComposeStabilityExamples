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
 * UnstableExample1
 * - Demonstrates instability caused by passing a standard `List`.
 * - Standard `List` is mutable and thus not guaranteed to maintain stability, even if not explicitly modified.
 */
@Composable
fun UnstableExample1(
    items: List<String>, // ❌ List is mutable
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.unstable1)
                onImageClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = items.joinToString())
    }
}