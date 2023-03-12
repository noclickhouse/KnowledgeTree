package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.components.base.buttons.ButtonWithText
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun Branch(
    text: String,
    onClick: () -> Unit,
) {
    ButtonWithText(
        text = text,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
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