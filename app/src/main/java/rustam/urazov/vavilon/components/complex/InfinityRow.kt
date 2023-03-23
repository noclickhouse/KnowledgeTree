package rustam.urazov.vavilon.components.complex

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.Branch

@Composable
fun InfinityRow(
    branches: List<Branch.BranchView>
) {
    Layout(
        content = {
            branches.forEach { branch ->
                BranchItem(text = branch.title) {

                }
            }
        },
        modifier = Modifier,
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        layout(constraints.minWidth, constraints.minHeight) {
            var xPosition = 0

            placeables.forEach { placeable ->
                placeable.placeRelative(x = xPosition, y = 0)
                xPosition += placeable.width
            }
        }
    }
}

@Composable
@Preview
fun InfinityRowPreview() {
    VavilonTheme {
        InfinityRow(
            listOf(
                Branch.BranchView(1, "assdd", 0, 0, 0f),
                Branch.BranchView(2, "dsdsd", 0, 1, 0f)
            )
        )
    }
}