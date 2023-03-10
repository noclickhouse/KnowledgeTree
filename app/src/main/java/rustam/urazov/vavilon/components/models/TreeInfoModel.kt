package rustam.urazov.vavilon.components.models

import androidx.annotation.DrawableRes

data class TreeInfoModel(
    val name: String,
    @DrawableRes val image: Int,
    val progress: Float
)