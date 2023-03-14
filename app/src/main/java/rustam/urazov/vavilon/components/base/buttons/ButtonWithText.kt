package rustam.urazov.vavilon.components.base.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.texts.LargeText
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun ButtonWithText(
    @StringRes textId: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        contentPadding = PaddingValues(vertical =  16.dp, horizontal = 32.dp)
    ) {
        LargeText(textId = textId)
    }
}

@Composable
fun ButtonWithText(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primary,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        contentPadding = PaddingValues(vertical =  16.dp, horizontal = 32.dp)
    ) {
        LargeText(text = text)
    }
}

@Composable
@Preview
fun ButtonWithTextPreview() {
    VavilonTheme {
        Column {
            ButtonWithText(onClick = {  }, textId = R.string.add)
            ButtonWithText(onClick = {  }, text = "Add")
        }
    }
}