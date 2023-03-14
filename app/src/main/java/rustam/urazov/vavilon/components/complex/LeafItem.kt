package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.components.base.buttons.ButtonWithText
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun LeafItem(
    text: String,
    isCompleted: Boolean,
    onClick: () -> Unit
) {
    ButtonWithText(
        text = text,
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp),
        backgroundColor =
        when (isCompleted) {
            true -> MaterialTheme.colors.primary
            false -> MaterialTheme.colors.secondary
        },
        onClick = onClick
    )
}

@Composable
@Preview
fun LeafPreview() {
    VavilonTheme {
        LeafItem("asd", true) {}
    }
}