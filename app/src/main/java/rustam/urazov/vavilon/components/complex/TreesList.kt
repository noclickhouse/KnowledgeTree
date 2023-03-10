package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.models.TreeInfoModel
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun TreesList(trees: List<TreeInfoModel>) {
    LazyRow {
        items(trees) { tree ->
            TreeView(
                modifier = Modifier.fillParentMaxSize(),
                treeName = tree.name,
                treeImage = tree.image,
                progress = tree.progress
            ) {

            }
            AddTreeButton(modifier = Modifier.fillParentMaxSize()) {

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
                TreeInfoModel("asd", R.drawable.add_24, 0.4f)
            )
        )
    }
}