package rustam.urazov.vavilon.data.repositories.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BranchesDao {

    @Query("SELECT * FROM ${BranchEntity.TABLE_NAME} WHERE parentId LIKE :root")
    suspend fun getBranches(root: Int?): List<BranchEntity>

    @Insert
    suspend fun addBranch(branch: BranchEntity)

}