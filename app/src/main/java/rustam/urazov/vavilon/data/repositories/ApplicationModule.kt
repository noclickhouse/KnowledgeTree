package rustam.urazov.vavilon.data.repositories

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import rustam.urazov.vavilon.data.repositories.storage.BranchEntity
import rustam.urazov.vavilon.data.repositories.storage.KnowledgeTreeDatabase
import rustam.urazov.vavilon.data.repositories.storage.LeafEntity
import rustam.urazov.vavilon.data.repositories.storage.empty
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideBranchRepository(branchRepository: BranchRepositoryImpl): BranchRepository = branchRepository

    @Provides
    @Singleton
    fun provideKnowledgeTreeDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, KnowledgeTreeDatabase::class.java, KnowledgeTreeDatabase.DB_NAME)
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideBranchesDao(db: KnowledgeTreeDatabase) = db.getBranchesDao()

    @Provides
    @Singleton
    fun provideLeafsDao(db: KnowledgeTreeDatabase) = db.getLeafsDao()

    @Provides
    fun provideBranchEntity() = BranchEntity.empty()

    @Provides
    fun provideLeafEntity() = LeafEntity.empty()
}