package rustam.urazov.vavilon.components.complex

import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import rustam.urazov.vavilon.components.models.AddDialogState
import rustam.urazov.vavilon.viewmodels.BranchView
import rustam.urazov.vavilon.viewmodels.BranchesViewModel

@Composable
fun AddView(
    viewModel: BranchesViewModel,
    dialogState: AddDialogState
) {
    if (dialogState is AddDialogState.Open) {
        Dialog(onDismissRequest = {
            viewModel.saveBranch(
                BranchView(
                    id = 0,
                    title = dialogState.title,
                    parentId = dialogState.parentId
                )
            )
        }) {
            TextField(
                value = dialogState.title,
                onValueChange = {
                    viewModel.onDialogTextChanged(
                        root = dialogState.parentId,
                        text = it
                    )
                }
            )
        }
    }
}