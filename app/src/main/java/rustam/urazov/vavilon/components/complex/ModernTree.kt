package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.Branch

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
        val branches = listOf(
            Branch.BranchView(1, "asd", 0, 0, 0f),
            Branch.BranchView(2, "sdf", 0, 0,0f),
            Branch.BranchView(3, "qwe", 1, 0, 0f),
            Branch.BranchView(4, "fgh", 1, 0, 0f)
        )
        InfinityRow(branches)
    }
}

@Composable
@Preview
fun ModernTreePreview() {
    VavilonTheme {
        ModernTree()
    }
}
