package rustam.urazov.vavilon.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import rustam.urazov.vavilon.data.repositories.Branch
import rustam.urazov.vavilon.data.repositories.BranchRepository

@HiltViewModel
class BranchesViewModel(
    private val branchRepository: BranchRepository
) : ViewModel() {

    private val mutableBranches: MutableStateFlow<List<BranchView>> = MutableStateFlow(emptyList())
    val branches: StateFlow<List<BranchView>> = mutableBranches.asStateFlow()

    fun getBranches(root: Int?) {
        viewModelScope.launch {
            mutableBranches.value = branchRepository.getBranches(root).map { map(it) }
        }
    }

    private fun map(branch: Branch): BranchView = BranchView(
        id = branch.id,
        title = branch.title,
        parentId = branch.parentId
    )
}