package rustam.urazov.vavilon.components.complex

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.buttons.WideButtonWithText
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun SaveButton(
    onClick: () -> Unit
) {
    WideButtonWithText(
        textId = R.string.save,
        onClick = onClick
    )
}

@Composable
@Preview
fun SaveButtonPreview() {
    VavilonTheme {
        SaveButton {

        }
    }
}