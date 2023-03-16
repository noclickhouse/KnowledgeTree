package rustam.urazov.vavilon.viewmodels

import rustam.urazov.vavilon.data.repositories.BranchModel
import rustam.urazov.vavilon.data.repositories.LeafModel

sealed class Branch(val parentId: Int) {
    data class BranchView(
        val id: Int = 0,
        val title: String,
        val parent: Int,
        val percentage: Float = 0f
    ) : Branch(parent)
    data class LeafView(
        val id: Int = 0,
        val content: String,
        val isCompleted: Boolean = false,
        val parent: Int
    ) : Branch(parent)
}

fun Branch.BranchView.toModel(): BranchModel = BranchModel(
    id = id,
    title = title,
    parentId = parentId,
    percentage = percentage
)

fun Branch.LeafView.toModel(): LeafModel = LeafModel(
    id = id,
    content = content,
    isCompleted = isCompleted,
    parentId = parentId
)