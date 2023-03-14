package rustam.urazov.vavilon.data.repositories.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import rustam.urazov.vavilon.core.empty

@Entity(tableName = LeafEntity.TABLE_NAME)
data class LeafEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "isCompleted") val isCompleted: Boolean,
    @ColumnInfo(name = "parentId") val parentId: Int
) {

    companion object {
        const val TABLE_NAME = "Leafs"
    }

}

fun LeafEntity.Companion.empty(): LeafEntity = LeafEntity(
    content = String.empty(),
    isCompleted = false,
    parentId = -2
)