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

/**
 * StableExample1
 * - Demonstrates stability with a simple immutable parameter.
 * - `title` is a primitive type and immutable by default, so this composable does not recompose unnecessarily.
 */
@Composable
fun StableExample1(
    modifier: Modifier = Modifier,
    title: String, // ✅ Immutable primitive type
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.stable1)
                onImageClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title)
    }
}