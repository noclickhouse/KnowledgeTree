package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.components.base.buttons.ButtonWithText
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun BranchItem(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    ButtonWithText(
        text = text,
        modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp),
        onClick = onClick
    )
}

@Composable
@Preview
fun BranchPreview() {
    VavilonTheme {
        BranchItem("dsa") {

        }
    }
}