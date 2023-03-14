package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.Branch
import rustam.urazov.vavilon.viewmodels.BranchesViewModel

@Composable
fun TreeScreen(
    navController: NavHostController,
    viewModel: BranchesViewModel,
    id: Int
) {
    val branches by viewModel.branches.collectAsState()
    val leafs by viewModel.leafs.collectAsState()
    val dialogState by viewModel.addDialogState.collectAsState()

    viewModel.getData(id)

    BoxWithConstraints(
        modifier = Modifier.padding(16.dp)
    ) {
        val height = maxHeight
        Column {
            BranchesList(
                height = height,
                branches = branches,
                leafs = leafs,
                navigate = { navController.navigate("branch/${it}") },
                updateLeaf = { viewModel.updateLeaf(it) }
            )
            AddButton {
                viewModel.addBranch(id)
            }
        }
    }

    AddView(
        dialogState = dialogState,
        onTextChange = { viewModel.onDialogTextChanged(id, it) },
        onBranchSave = {
            viewModel.saveBranch(
                Branch.BranchView(
                    title = it,
                    parentId = id
                )
            )
        },
        onLeafSave = {
            viewModel.saveLeaf(
                Branch.LeafView(
                    content = it,
                    parentId = id
                )
            )
        },
        onClose = { viewModel.closeDialog() }
    )
}

@Composable
@Preview
fun TreeScreenPreview() {
    VavilonTheme {
        val viewModel: BranchesViewModel = hiltViewModel()
        TreeScreen(rememberNavController(), viewModel, -1)
    }
}