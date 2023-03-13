package rustam.urazov.vavilon.data.repositories

data class Branch(
    val id: Int,
    val title: String,
    val parentId: Int?
)