package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.Branch

@Composable
fun ModernBranch(
    root: Int,
    branches: List<Branch>
) {
    BoxWithConstraints {
        Column {
            val brs = branches.filter { it.parentId == root }
            repeat(brs.size) {
                when (val br = brs[it]) {
                    is Branch.BranchView -> {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            BranchItem(text = br.title) {

                            }
                            ModernBranch(
                                root = br.id,
                                branches = branches.filter { it.parentId != br.parentId })
                        }
                    }
                    is Branch.LeafView -> LeafItem(
                        text = br.content,
                        isCompleted = br.isCompleted
                    ) {

                    }
                }
            }
        }
    }

}

@Composable
@Preview
fun ModernBranchPreview() {
    VavilonTheme {
        val branches: List<Branch> = listOf(
            Branch.BranchView(1, "asd", 0, 0f),
            Branch.BranchView(2, "sdf", 0, 0f),
            Branch.BranchView(3, "qwe", 1, 0f),
            Branch.LeafView(1, "dfg", false, 3),
            Branch.LeafView(2, "fgh", false, 2),
            Branch.LeafView(3, "ghj", false, 3),
        )
        ModernBranch(0, branches)
    }
}