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
 * UnstableExample2
 * - Demonstrates instability with a custom class that lacks `equals` and `hashCode`.
 * - Even though `title` is immutable, the lack of these methods prevents Compose from detecting stability.
 */
class Items(
    val title: String // ❌ The Items class is not stable
)

@Composable
fun UnstableExample2(
    items: Items,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .recomposeHighlighter()
            .clickable {
                onImageChange(R.drawable.unstable2)
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