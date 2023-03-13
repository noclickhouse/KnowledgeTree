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
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.BranchView
import rustam.urazov.vavilon.viewmodels.BranchesViewModel

@Composable
fun TreeScreen(
    viewModel: BranchesViewModel
) {
    val branches by viewModel.branches.collectAsState()
    viewModel.getBranches(-1)

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

                    }
                }
            }
            AddButton {
                viewModel.addBranch(BranchView("asd", -1))
            }
        }
    }
}

@Composable
@Preview
fun TreeScreenPreview() {
    VavilonTheme {
        val viewModel: BranchesViewModel = hiltViewModel()
        TreeScreen(viewModel)
    }
}