package rustam.urazov.vavilon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import rustam.urazov.vavilon.ui.theme.VavilonTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VavilonTheme {
                KnowledgeTreeNavGraph(navController = rememberNavController())
            }
        }
    }
}