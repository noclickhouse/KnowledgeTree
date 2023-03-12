package rustam.urazov.vavilon.components.complex

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.components.base.buttons.ButtonWithText
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun Branch(
    text: String,
    onClick: () -> Unit,
) {
    ButtonWithText(
        text = text,
        onClick = onClick
    )
}

@Composable
@Preview
fun BranchPreview() {
    VavilonTheme {
        Branch("dsa") {

        }
    }
}