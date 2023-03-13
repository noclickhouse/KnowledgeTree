package rustam.urazov.vavilon.data.repositories

import rustam.urazov.vavilon.data.repositories.storage.BranchEntity

data class Branch(
    val id: Int,
    val title: String,
    val parentId: Int
)

fun Branch.toEntity(): BranchEntity = BranchEntity(
    title = title,
    parentId = parentId
)