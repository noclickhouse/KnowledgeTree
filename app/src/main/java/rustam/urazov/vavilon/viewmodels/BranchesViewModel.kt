package rustam.urazov.vavilon.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import rustam.urazov.vavilon.components.models.AddDialogState
import rustam.urazov.vavilon.core.empty
import rustam.urazov.vavilon.data.repositories.BranchModel
import rustam.urazov.vavilon.data.repositories.LeafModel
import rustam.urazov.vavilon.usecases.*
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel
@Inject constructor(
    private val getBranches: GetBranchesUseCase,
    private val addBranch: AddBranchUseCase,
    private val getLeafs: GetLeafsUseCase,
    private val addLeaf: AddLeafUseCase,
    private val updateLeaf: UpdateLeafUseCase
) : ViewModel() {

    private val mutableBranches: MutableStateFlow<List<Branch.BranchView>> =
        MutableStateFlow(emptyList())
    val branches: StateFlow<List<Branch.BranchView>> = mutableBranches.asStateFlow()

    private val mutableLeafs: MutableStateFlow<List<Branch.LeafView>> =
        MutableStateFlow(emptyList())
    val leafs: StateFlow<List<Branch.LeafView>> = mutableLeafs.asStateFlow()

    private val mutableAddDialogState: MutableStateFlow<AddDialogState> =
        MutableStateFlow(AddDialogState.Closed)
    val addDialogState: StateFlow<AddDialogState> = mutableAddDialogState.asStateFlow()

    fun getData(root: Int) {
        getBranches(root)
        getLeafs(root)
    }

    private fun getBranches(root: Int) = getBranches(root, viewModelScope) {
        mutableBranches.value = it.map { branch ->
            var percentage = 0f
            getBranches(branch.id, viewModelScope) { branches ->
                val childBranches = branches
                getLeafs(branch.id, viewModelScope) { leafs ->
                    val childLeafs = leafs
                    val count = childBranches.size + childLeafs.size
                    childBranches.forEach { child ->
                        percentage += child.percentage / count
                    }
                    childLeafs.forEach { leaf ->
                        percentage += if (leaf.isCompleted) 1f / count else 0f
                    }
                }
            }
            val branchResult = BranchModel(
                id = branch.id,
                title = branch.title,
                parentId = branch.parentId,
                percentage = percentage
            )
            map(branchResult)
        }
    }

    private fun getLeafs(root: Int) = getLeafs(root, viewModelScope) {
        mutableLeafs.value = it.map { leaf -> map(leaf) }
    }

    fun addBranch(root: Int) {
        openDialog(root)
    }

    fun saveBranch(branch: Branch.BranchView) = addBranch(branch.toModel(), viewModelScope) {
        getData(branch.parentId)
        closeDialog()
    }

    fun saveLeaf(leaf: Branch.LeafView) = addLeaf(leaf.toModel(), viewModelScope) {
        getData(leaf.parentId)
        closeDialog()
    }

    fun updateLeaf(leaf: Branch.LeafView) = updateLeaf(leaf.toModel(), viewModelScope) {
        getData(leaf.parentId)
    }

    private fun openDialog(root: Int) {
        mutableAddDialogState.value = AddDialogState.Open(root, String.empty())
    }

    fun onDialogTextChanged(root: Int, text: String) {
        mutableAddDialogState.value = AddDialogState.Open(root, text)
    }

    fun closeDialog() {
        mutableAddDialogState.value = AddDialogState.Closed
    }

    private fun map(branch: BranchModel): Branch.BranchView = Branch.BranchView(
        id = branch.id,
        title = branch.title,
        parent = branch.parentId,
        percentage = branch.percentage,
        previousId = 0
    )

    private fun map(leaf: LeafModel): Branch.LeafView = Branch.LeafView(
        id = leaf.id,
        content = leaf.content,
        isCompleted = leaf.isCompleted,
        parent = leaf.parentId
    )
}