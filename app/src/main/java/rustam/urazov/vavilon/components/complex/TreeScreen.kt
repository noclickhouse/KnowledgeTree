package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.BranchesViewModel

@Composable
fun TreeScreen(
    navController: NavHostController,
    viewModel: BranchesViewModel,
    id: Int
) {
    val branches by viewModel.branches.collectAsState()

    viewModel.getBranches(id)

    val dialogState by viewModel.addDialogState.collectAsState()

    BoxWithConstraints(
        modifier = Modifier.padding(16.dp)
    ) {
        val height = maxHeight
        Column {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height - 60.dp),
                state = rememberLazyListState(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(branches) { branch ->
                    Branch(text = branch.title) {
                        navController.navigate("branch/${branch.id}")
                    }
                }
            }
            AddButton {
                viewModel.addBranch(id)
            }
        }
    }

    AddView(viewModel = viewModel, dialogState = dialogState)
}

@Composable
@Preview
fun TreeScreenPreview() {
    VavilonTheme {
        val viewModel: BranchesViewModel = hiltViewModel()
        TreeScreen(rememberNavController(), viewModel, -1)
    }
}