package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun TreesList(trees: List<TreeInfo>) {
    LazyRow {
        items(trees) { tree ->

        }
    }
}

@Composable
@Preview
fun TreesListPreview() {
    VavilonTheme {
        TreesList()
    }
}