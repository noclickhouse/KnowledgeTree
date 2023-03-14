package rustam.urazov.vavilon.data.repositories.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BranchEntity.TABLE_NAME)
data class BranchEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "parentId") val parentId: Int
) {

    companion object {
        const val TABLE_NAME = "Branches"
    }

}

fun BranchEntity.Companion.empty(): BranchEntity = BranchEntity(
    title = "",
    parentId = -2
)