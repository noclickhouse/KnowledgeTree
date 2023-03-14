package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.viewmodels.Branch

@Composable
fun BranchesList(
    height: Dp,
    branches: List<Branch.BranchView>,
    leafs: List<Branch.LeafView>,
    navigate: (Int) -> Unit,
    updateLeaf: (Branch.LeafView) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(height - 60.dp),
        state = rememberLazyListState(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(branches) { branch ->
            BranchItem(text = branch.title) {
                navigate(branch.id)
            }
        }
        items(leafs) { leaf ->
            LeafItem(text = leaf.content, isCompleted = leaf.isCompleted) {
                updateLeaf(
                    Branch.LeafView(
                        id = leaf.id,
                        content = leaf.content,
                        isCompleted = !leaf.isCompleted,
                        parentId = leaf.parentId
                    )
                )
            }
        }
    }
}