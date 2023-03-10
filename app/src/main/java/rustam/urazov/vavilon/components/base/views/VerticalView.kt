package rustam.urazov.vavilon.components.base.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import rustam.urazov.vavilon.components.models.ContentPadding

@Composable
fun VerticalView(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    shape: Shape,
    onClick: () -> Unit,
    contentPadding: ContentPadding,
    verticalAlignment: Alignment.Vertical,
    content: @Composable ColumnScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor)
    ) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = contentPadding.vertical,
                    horizontal = contentPadding.horizontal
                )
                .align(alignment = verticalAlignment),
            horizontalAlignment = Alignment.CenterHorizontally,
            content = content
        )
    }
}