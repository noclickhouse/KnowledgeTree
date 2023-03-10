package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.images.WideImage
import rustam.urazov.vavilon.components.base.views.VerticalView

@Composable
fun TreeView(
    onClick: () -> Unit
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val height = maxHeight
        VerticalView(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = Color(0xed, 0x89, 0xcb),
            shape = RoundedCornerShape(16.dp),
            onClick = onClick
        ) {
            val color = Color(0x89, 0xed, 0xaa)
            WideImage(
                imageId = R.drawable.add_24,
                contentDescription = "",
                modifier = Modifier.height(height) .background(
                    color = Color(0xdc, 0x89, 0xed),
                    shape = RoundedCornerShape(16.dp)
                ),
                colorFilter = ColorFilter.tint(color)
            )
            Text(
                text = "asd",
                color = color,
                fontSize = 24.sp
            )
        }
    }
}

@Composable
@Preview
fun TreeViewPreview() {
    TreeView {

    }
}