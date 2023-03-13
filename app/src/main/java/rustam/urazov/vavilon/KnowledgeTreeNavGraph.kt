package rustam.urazov.vavilon

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import rustam.urazov.vavilon.components.complex.TreeScreen
import rustam.urazov.vavilon.viewmodels.BranchesViewModel

@Composable
fun KnowledgeTreeNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "branch/-1"
    ) {
        composable(
            route = "branch/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            val viewModel: BranchesViewModel = hiltViewModel()
            TreeScreen(navController = navController, viewModel = viewModel, it.arguments?.getInt("id") ?: -1)
        }
    }
}