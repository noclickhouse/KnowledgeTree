package rustam.urazov.vavilon.data.repositories

import rustam.urazov.vavilon.data.repositories.storage.BranchEntity

data class BranchModel(
    val id: Int,
    val title: String,
    val parentId: Int
)

fun BranchModel.toEntity(): BranchEntity = BranchEntity(
    title = title,
    parentId = parentId
)