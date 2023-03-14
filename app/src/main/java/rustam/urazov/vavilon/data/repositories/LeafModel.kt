package rustam.urazov.vavilon.data.repositories

import rustam.urazov.vavilon.data.repositories.storage.LeafEntity

data class LeafModel(
    val id: Int,
    val content: String,
    val isCompleted: Boolean,
    val parentId: Int
)

fun LeafModel.toEntity(): LeafEntity = LeafEntity(
    id = id,
    content = content,
    isCompleted = isCompleted,
    parentId = parentId
)