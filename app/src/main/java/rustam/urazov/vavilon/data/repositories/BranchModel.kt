package rustam.urazov.vavilon.data.repositories

import rustam.urazov.vavilon.data.repositories.storage.BranchEntity

data class BranchModel(
    val id: Int,
    val title: String,
    val parentId: Int,
    val percentage: Float
)

fun BranchModel.toEntity(): BranchEntity = BranchEntity(
    title = title,
    parentId = parentId,
    percentage = percentage
)