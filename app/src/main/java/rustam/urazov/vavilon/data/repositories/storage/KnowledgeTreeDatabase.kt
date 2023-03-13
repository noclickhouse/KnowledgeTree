package rustam.urazov.vavilon.data.repositories.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BranchEntity::class], version = 1)
abstract class KnowledgeTreeDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "KnowledgeTreeDb"
    }

    abstract fun getBranchesDao(): BranchesDao

}