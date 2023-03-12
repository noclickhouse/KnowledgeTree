package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.buttons.WideButtonWithText

@Composable
fun AddButton() {
    WideButtonWithText(
        onClick = { },
        shape = RoundedCornerShape(16.dp),
        textId = R.string.add
    )
}

@Composable
@Preview
fun AddButtonPreview() {
    AddButton()
}