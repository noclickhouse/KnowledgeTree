package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.Branch

@Composable
fun ModernRow(
    branches: List<Branch>,
    br: Branch.BranchView
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        BranchItem(text = br.title) {

        }
        ModernBranch(
            root = br.id,
            branches = branches.filter { it.parentId != br.parentId }
        )
    }
}

@Composable
@Preview
fun ModernRowPreview() {
    VavilonTheme {
        val branches: List<Branch> = listOf(
            Branch.BranchView(1, "asd", 0, 0, 0f),
            Branch.BranchView(2, "sdf", 0, 0, 0f),
            Branch.BranchView(3, "qwe", 1, 0, 0f),
            Branch.LeafView(1, "dfg", false, 3),
            Branch.LeafView(2, "fgh", false, 2),
            Branch.LeafView(3, "ghj", false, 3),
        )
        ModernRow(branches, branches[0] as Branch.BranchView)
    }
}