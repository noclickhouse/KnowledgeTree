package rustam.urazov.vavilon.components.base.buttons

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource

@Composable
fun WideButtonWithText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    shape: Shape,
    @StringRes textId: Int
) {
    WideButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape
    ) {
        Text(text = stringResource(id = textId))
    }
}

@Composable
fun WideButtonWithText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    shape: Shape,
    text: String
) {
    WideButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape
    ) {
        Text(text = text)
    }
}