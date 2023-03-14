package rustam.urazov.vavilon.data.repositories

import rustam.urazov.vavilon.data.repositories.storage.LeafEntity

data class Leaf(
    val id: Int,
    val content: String,
    val isCompleted: Boolean,
    val parentId: Int
)

fun Leaf.toEntity(): LeafEntity = LeafEntity(
    content = content,
    isCompleted = isCompleted,
    parentId = parentId
)