package rustam.urazov.vavilon.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import rustam.urazov.vavilon.components.models.AddDialogState
import rustam.urazov.vavilon.core.empty
import rustam.urazov.vavilon.data.repositories.BranchModel
import rustam.urazov.vavilon.data.repositories.BranchRepository
import rustam.urazov.vavilon.data.repositories.LeafModel
import rustam.urazov.vavilon.data.repositories.LeafRepository
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel
@Inject constructor(
    private val branchRepository: BranchRepository,
    private val leafRepository: LeafRepository
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

    private fun getBranches(root: Int) {
        viewModelScope.launch {
            mutableBranches.value = branchRepository.getBranches(root).map {
                val childBranches = branchRepository.getBranches(it.id)
                val childLeafs = leafRepository.getLeafs(it.id)
                val count = childBranches.size + childLeafs.size
                var percentage = 0f
                childBranches.forEach { child ->
                    percentage += child.percentage / count
                }
                childLeafs.forEach { leaf ->
                    percentage += if (leaf.isCompleted) 1f / count else 0f
                }
                val branch = BranchModel(
                    id = it.id,
                    title = it.title,
                    parentId = it.parentId,
                    percentage = percentage
                )
                map(branch)
            }
        }
    }

    private fun getLeafs(root: Int) {
        viewModelScope.launch {
            mutableLeafs.value = leafRepository.getLeafs(root).map { map(it) }
        }
    }

    fun addBranch(root: Int) {
        openDialog(root)
    }

    fun saveBranch(branch: Branch.BranchView) {
        viewModelScope.launch {
            branchRepository.addBranch(branch.toModel())
            getData(branch.parentId)
            closeDialog()
        }
    }

    fun saveLeaf(leaf: Branch.LeafView) {
        viewModelScope.launch {
            leafRepository.addLeaf(leaf.toModel())
            getData(leaf.parentId)
            closeDialog()
        }
    }

    fun updateLeaf(leaf: Branch.LeafView) {
        viewModelScope.launch {
            leafRepository.updateLeaf(leaf.toModel())
            getData(leaf.parentId)
        }
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
        parentId = branch.parentId,
        percentage = branch.percentage
    )

    private fun map(leaf: LeafModel): Branch.LeafView = Branch.LeafView(
        id = leaf.id,
        content = leaf.content,
        isCompleted = leaf.isCompleted,
        parentId = leaf.parentId
    )
}