package rustam.urazov.vavilon.data.repositories.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = BranchEntity.TABLE_NAME)
data class BranchEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val title: String,
    val parentId: Int?
) {

    companion object {
        const val TABLE_NAME = "Branches"
    }

}