package rustam.urazov.vavilon.components.base.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.texts.LargeText
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun WideButtonWithText(
    @StringRes textId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    WideButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        LargeText(
            modifier = Modifier.fillMaxWidth(),
            textId = textId
        )
    }
}

@Composable
fun WideButtonWithText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    WideButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        LargeText(
            modifier = Modifier.fillMaxWidth(),
            text = text
        )
    }
}

@Composable
@Preview
fun WideButtonWithTextPreview() {
    VavilonTheme {
        Column {
            WideButtonWithText(onClick = { }, textId = R.string.add)
            WideButtonWithText(onClick = { }, text = "Add")
        }
    }
}