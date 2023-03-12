package rustam.urazov.vavilon.components.models

data class BranchModel(
    val id: Int,
    val title: String,
    val parentId: Int?
)