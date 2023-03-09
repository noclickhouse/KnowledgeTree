package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.views.VerticalView

@Composable
fun AddTreeButton(
    onClick: () -> Unit
) {
    VerticalView(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color(0xed, 0x89, 0xcb),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick
    ) {
        val color = Color(0x89, 0xed, 0xaa)
        Image(
            painter = painterResource(id = R.drawable.add_24),
            contentDescription = stringResource(id = R.string.click_for_add_tree),
            colorFilter = ColorFilter.tint(color)
        )
        Text(text = stringResource(id = R.string.click_for_add_tree), color = color)
    }
}

@Composable
@Preview
fun AddTreeButtonPreview() {
    AddTreeButton {

    }
}