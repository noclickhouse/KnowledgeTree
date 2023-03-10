package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProgressBar(
    progress: Float
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(32.dp))
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .matchParentSize()) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(progress)
                    .background(Color(0x89, 0xed, 0xaa))
            ) {}
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xba, 0xba, 0xba))
            ) {}
        }
        Text(
            text = "${(progress * 100).toInt()}%",
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            color = Color(0xed, 0x89, 0xcb),
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
@Preview
fun ProgressBarPreview() {
    ProgressBar(0.6f)
}