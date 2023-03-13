package rustam.urazov.vavilon.viewmodels

import rustam.urazov.vavilon.data.repositories.Branch

data class BranchView(
    val id: Int,
    val title: String,
    val parentId: Int
)

fun BranchView.toModel(): Branch = Branch(
    id = id,
    title = title,
    parentId = parentId
)