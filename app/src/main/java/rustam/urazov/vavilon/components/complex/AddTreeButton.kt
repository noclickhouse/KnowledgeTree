package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.views.VerticalView
import rustam.urazov.vavilon.components.models.ContentPadding

@Composable
fun AddTreeButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    VerticalView(
        modifier = modifier.fillMaxSize(),
        backgroundColor = Color(0xed, 0x89, 0xcb),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick,
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = ContentPadding(
            vertical = 8.dp,
            horizontal = 16.dp
        )
    ) {
        val color = Color(0x89, 0xed, 0xaa)
        Image(
            painter = painterResource(id = R.drawable.add_24),
            contentDescription = stringResource(id = R.string.click_for_add_tree),
            modifier = Modifier.size(48.dp),
            colorFilter = ColorFilter.tint(color)
        )
        Text(
            text = stringResource(id = R.string.click_for_add_tree),
            color = color,
            fontSize = 24.sp
        )
    }
}

@Composable
@Preview
fun AddTreeButtonPreview() {
    AddTreeButton {

    }
}