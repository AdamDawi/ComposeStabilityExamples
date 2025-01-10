package com.example.composestabilityexamples.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.android.compose.recomposehighlighter.recomposeHighlighter
import com.example.composestabilityexamples.R
import com.example.composestabilityexamples.bad_examples.Items
import com.example.composestabilityexamples.bad_examples.Items3
import com.example.composestabilityexamples.bad_examples.Items7
import com.example.composestabilityexamples.bad_examples.Items8
import com.example.composestabilityexamples.bad_examples.UnstableExample1
import com.example.composestabilityexamples.bad_examples.UnstableExample2
import com.example.composestabilityexamples.bad_examples.UnstableExample3
import com.example.composestabilityexamples.bad_examples.UnstableExample4
import com.example.composestabilityexamples.bad_examples.UnstableExample5
import com.example.composestabilityexamples.good_examples.FootNote
import com.example.composestabilityexamples.good_examples.Items2
import com.example.composestabilityexamples.good_examples.Items5
import com.example.composestabilityexamples.good_examples.Items6
import com.example.composestabilityexamples.good_examples.StableExample1
import com.example.composestabilityexamples.good_examples.StableExample2
import com.example.composestabilityexamples.good_examples.StableExample3
import com.example.composestabilityexamples.good_examples.StableExample4
import com.example.composestabilityexamples.good_examples.StableExample5
import com.example.composestabilityexamples.main_screen.components.DialogWithImage
import kotlinx.collections.immutable.persistentListOf

@Composable
fun MainScreen() {
    val sliderPosition = remember { mutableFloatStateOf(0f) }
    var showDialog by remember { mutableStateOf(false) }
    val currentImage = remember {
        mutableIntStateOf(R.drawable.stable1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showDialog) {
            DialogWithImage(
                onDismissRequest = { showDialog = false },
                painter = painterResource(currentImage.intValue)
            )
        }
        Slider(
            value = sliderPosition.floatValue,
            onValueChange = { sliderPosition.floatValue = it }
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .recomposeHighlighter(),
            text = sliderPosition.floatValue.toString(),
            textAlign = TextAlign.Center
        )

        LazyVerticalGrid(
            modifier = Modifier.padding(horizontal = 8.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            gridExamples(
                sliderPosition = sliderPosition,
                onImageClick = { showDialog = true },
                onImageChange = { currentImage.intValue = it }
            )
        }
    }
}

private fun LazyGridScope.gridExamples(
    sliderPosition: MutableFloatState,
    onImageClick: () -> Unit,
    onImageChange: (Int) -> Unit
) {
    //slider position only for triggering recomposition in this scope
    item {
        val sliderPositionValue = sliderPosition.floatValue
        StableExample1(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            title = "Stable 1"
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        UnstableExample1(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = listOf("Unstable 1")
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        StableExample2(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = persistentListOf("Stable 2")
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        UnstableExample2(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = Items(title = "Unstable 2")
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        StableExample3(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = Items2(items = listOf("Stable 3"))
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        UnstableExample3(
            onImageClick = onImageClick,
            onImageChange = onImageChange, items = Items3(items = listOf("Unstable 3"))
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        StableExample4(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = Items5(
                title = "Stable 4",
                items = persistentListOf("Stable 4"),
                footnote = FootNote("Stable 4")
            )
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        UnstableExample4(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = Items7(
                title = "Unstable 4"
            )
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        StableExample5(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = Items6(items = mutableListOf("Stable 5"))
        )
    }
    item {
        val sliderPositionValue = sliderPosition.floatValue
        UnstableExample5(
            onImageClick = onImageClick,
            onImageChange = onImageChange,
            items = Items8(items = mutableListOf("Unstable 5"))
        )
    }
}