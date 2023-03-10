package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.components.models.TreeInfoModel
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun TreesList(trees: List<TreeInfoModel>) {
    LazyRow {
        items(trees) { tree ->
            TreeView(
                treeName = tree.name,
                treeImage = null,
                treeContentDescription = ""
            ) {

            }
            AddTreeButton {

            }
        }
    }
}

@Composable
@Preview
fun TreesListPreview() {
    VavilonTheme {
        TreesList(
            trees = listOf(
                TreeInfoModel("asd", "", 0.4f)
            )
        )
    }
}