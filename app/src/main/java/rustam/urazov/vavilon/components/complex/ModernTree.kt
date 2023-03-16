package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun ModernTree() {
    var x by remember { mutableStateOf(0) }
    var y by remember { mutableStateOf(0) }

    Column(
        Modifier
            .offset { IntOffset(x, y) }
            .pointerInput(Unit) {
                detectDragGestures { _, dragAmount ->
                    x += dragAmount.x.toInt()
                    y += dragAmount.y.toInt()
                }
            }
            .width(10000.dp)
            .height(10000.dp)
    ) {

    }
}

@Composable
@Preview
fun ModernTreePreview() {
    VavilonTheme {
        ModernTree()
    }
}
