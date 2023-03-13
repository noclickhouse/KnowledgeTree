package rustam.urazov.vavilon.viewmodels

import rustam.urazov.vavilon.data.repositories.Branch

data class BranchView(
    val title: String,
    val parentId: Int
)

fun BranchView.toModel(): Branch = Branch(
    title = title,
    parentId = parentId
)