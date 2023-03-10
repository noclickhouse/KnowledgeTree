package rustam.urazov.vavilon.components.base.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BaseProgressBar(
    progress: Float,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier
        .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(progress)
                .background(MaterialTheme.colors.secondary)
        ) {}
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
        ) {}
    }
}