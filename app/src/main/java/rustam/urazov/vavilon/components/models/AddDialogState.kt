package rustam.urazov.vavilon.components.models

sealed class AddDialogState {
    data class Open(
        val parentId: Int,
        val title: String
    ) : AddDialogState()
    object Closed : AddDialogState()
}