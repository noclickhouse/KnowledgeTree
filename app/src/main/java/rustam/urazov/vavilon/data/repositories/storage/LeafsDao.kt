package rustam.urazov.vavilon.data.repositories.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LeafsDao {

    @Query("SELECT * FROM ${LeafEntity.TABLE_NAME} WHERE parentId LIKE :root")
    fun getLeafs(root: Int): List<LeafEntity>

    @Insert
    fun addLeaf(leaf: LeafEntity)

}