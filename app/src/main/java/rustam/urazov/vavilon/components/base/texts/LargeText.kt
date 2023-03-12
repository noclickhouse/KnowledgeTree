package rustam.urazov.vavilon.components.base.texts

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Colum
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun LargeText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.secondary,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = 24.sp,
        textAlign = textAlign
    )
}

@Composable
fun LargeText(
    @StringRes textId: Int,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.secondary,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        text = stringResource(id = textId),
        modifier = modifier,
        color = color,
        fontSize = 24.sp,
        textAlign = textAlign
    )
}

@Composable
@Preview
fun LargeTextPreview() {
    VavilonTheme {
        Column {
            LargeText(text = "Add")
            LargeText(textId = R.string.add)
        }
    }
}