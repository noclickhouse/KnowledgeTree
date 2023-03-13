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
import rustam.urazov.vavilon.data.repositories.Branch
import rustam.urazov.vavilon.data.repositories.BranchRepository
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel
@Inject constructor(
    private val branchRepository: BranchRepository
) : ViewModel() {

    private val mutableBranches: MutableStateFlow<List<BranchView>> = MutableStateFlow(emptyList())
    val branches: StateFlow<List<BranchView>> = mutableBranches.asStateFlow()
    private val mutableAddDialogState: MutableStateFlow<AddDialogState> =
        MutableStateFlow(AddDialogState.Closed)
    val addDialogState: StateFlow<AddDialogState> = mutableAddDialogState.asStateFlow()

    fun getBranches(root: Int?) {
        viewModelScope.launch {
            mutableBranches.value = branchRepository.getBranches(root).map { map(it) }
        }
    }

    fun addBranch(root: Int) {
        openDialog(root)
    }

    fun saveBranch(branch: BranchView) {
        viewModelScope.launch {
            branchRepository.addBranch(branch.toModel())
            getBranches(branch.parentId)
            closeDialog()
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

    private fun map(branch: Branch): BranchView = BranchView(
        id = branch.id,
        title = branch.title,
        parentId = branch.parentId
    )
}