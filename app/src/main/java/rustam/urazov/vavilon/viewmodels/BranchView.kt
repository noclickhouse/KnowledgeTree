package rustam.urazov.vavilon.viewmodels

data class BranchView(
    val id: Int,
    val title: String,
    val parentId: Int?
)