package rustam.urazov.vavilon.components.complex

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import rustam.urazov.vavilon.components.models.AddDialogState

@Composable
fun AddView(
    dialogState: AddDialogState,
    onTextChange: (String) -> Unit,
    onSave: (String) -> Unit,
    onClose: () -> Unit
) {
    if (dialogState is AddDialogState.Open) {
        Dialog(onDismissRequest = onClose) {
            Column(
                modifier = Modifier.padding(horizontal = 36.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = dialogState.title,
                    onValueChange = onTextChange
                )
                SaveButton {
                    onSave(dialogState.title)
                }
            }
        }
    }
}