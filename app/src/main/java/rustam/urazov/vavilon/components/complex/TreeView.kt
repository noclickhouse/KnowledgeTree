package rustam.urazov.vavilon.components.complex

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import rustam.urazov.vavilon.R
import rustam.urazov.vavilon.components.base.images.WideImage
import rustam.urazov.vavilon.components.base.views.VerticalView
import rustam.urazov.vavilon.components.models.ContentPadding
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun TreeView(
    treeName: String,
    @DrawableRes treeImage: Int,
    treeContentDescription: String,
    onClick: () -> Unit
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val height = maxHeight
        VerticalView(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(16.dp),
            onClick = onClick,
            contentPadding = ContentPadding(
                vertical = 8.dp,
                horizontal = 16.dp
            )
        ) {
            WideImage(
                imageId = treeImage,
                contentDescription = treeContentDescription,
                modifier = Modifier
                    .height(height - 136.dp)
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(16.dp)
                    ),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.secondary)
            )
            Text(
                text = treeName,
                color = MaterialTheme.colors.secondary,
                fontSize = 24.sp
            )
            ProgressBarWithIndicator(progress = 0.6f)
        }
    }
}

@Composable
@Preview
fun TreeViewPreview() {
    VavilonTheme {
        TreeView("asd", R.drawable.add_24, "") {

        }
    }
}