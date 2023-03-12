package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.components.base.buttons.WideButton

@Composable
fun AddButton() {
    WideButton(
        onClick = {  }, shape = RoundedCornerShape(16.dp)
    ) {
        Text(text = "Add")
    }
}

@Composable
@Preview
fun AddButtonPreview() {
    AddButton()
}