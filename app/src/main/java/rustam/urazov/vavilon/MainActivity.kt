package rustam.urazov.vavilon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import rustam.urazov.vavilon.components.complex.TreeScreen
import rustam.urazov.vavilon.ui.theme.VavilonTheme
import rustam.urazov.vavilon.viewmodels.BranchesViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VavilonTheme {
                val treeScreenViewModel: BranchesViewModel = hiltViewModel()
                val branches by treeScreenViewModel.branches.collectAsState()
                TreeScreen(branches = branches)
            }
        }
    }
}