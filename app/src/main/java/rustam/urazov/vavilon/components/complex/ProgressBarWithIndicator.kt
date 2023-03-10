package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rustam.urazov.vavilon.components.base.common.BaseProgressBar
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@Composable
fun ProgressBarWithIndicator(
    progress: Float
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(32.dp))
    ) {
        BaseProgressBar(
            progress = progress,
            modifier = Modifier.matchParentSize()
        )
        Text(
            text = "${(progress * 100).toInt()}%",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            color = MaterialTheme.colors.primary,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun ProgressBarPreview() {
    VavilonTheme {
        ProgressBarWithIndicator(0.6f)
    }
}