package rustam.urazov.vavilon.components.base.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun WideButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(16.dp),
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        enabled = enabled,
        shape = shape,
        contentPadding = PaddingValues(16.dp),
        content = content
    )
}

@Composable
@Preview
fun WideButtonPreview() {
    VavilonTheme {
        WideButton(
            onClick = {  },
            shape = RoundedCornerShape(16.dp)
        ) {  }
    }
}