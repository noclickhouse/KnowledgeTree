package rustam.urazov.vavilon.components.complex

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.onFocusedBoundsChanged
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.Branch

@Composable
fun InfinityRow(
    branches: List<Branch.BranchView>
) {
    val widths = mutableListOf(0 to 0.dp)

    branches.forEach { branch ->
        val density = LocalDensity.current
        BranchItem(
            text = branch.title,
            modifier = Modifier
                .onGloballyPositioned {
                    density.run {
                        widths.add(branch.id to it.size.width.dp)
                    }
                }
                .offset(x = widths.find { branch.previousId == it.first }?.second ?: widths[0].second)
        ) {

        }
        widths.forEach {
            Log.e("asd", it.first.toString())
            Log.e("asd", it.second.toString())
        }
    }
}

@Composable
@Preview
fun InfinityRowPreview() {
    VavilonTheme {
        InfinityRow(
            listOf(
                Branch.BranchView(1, "assdd", 0, 0, 0f),
                Branch.BranchView(2, "dsdsd", 0, 1,0f)
            )
        )
    }
}