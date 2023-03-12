package rustam.urazov.vavilon.components.base.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun WideButtonWithText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    @StringRes textId: Int
) {
    WideButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = stringResource(id = textId))
    }
}

@Composable
fun WideButtonWithText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String
) {
    WideButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = text)
    }
}

@Composable
@Preview
fun WideButtonWithTextPreview() {
    VavilonTheme {
        Column {
            WideButtonWithText(onClick = {  }, textId = R.string.add)
            WideButtonWithText(onClick = {  }, text = "Add")
        }
    }
}