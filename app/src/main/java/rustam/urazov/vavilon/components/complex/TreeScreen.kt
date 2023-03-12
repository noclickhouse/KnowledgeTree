package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun TreeScreen() {
    BoxWithConstraints {
        val height = maxHeight
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height - 60.dp)
            ) {

            }
            AddButton()
        }
    }
}

@Composable
@Preview
fun TreeScreenPreview() {
    VavilonTheme {
        TreeScreen()
    }
}