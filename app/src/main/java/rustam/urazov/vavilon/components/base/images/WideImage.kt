package rustam.urazov.vavilon.components.base.images

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource

@Composable
fun WideImage(
    @DrawableRes imageId: Int,
    modifier: Modifier = Modifier,
    colorFilter: ColorFilter
) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
        colorFilter = colorFilter
    )
}