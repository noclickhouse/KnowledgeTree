package rustam.urazov.vavilon.data.repositories

import rustam.urazov.vavilon.data.repositories.storage.LeafEntity
import rustam.urazov.vavilon.data.repositories.storage.LeafsDao
import javax.inject.Inject

class LeafRepositoryImpl
@Inject constructor(
    private val leafsDao: LeafsDao
) : LeafRepository {

    override suspend fun getLeafs(root: Int): List<Leaf> = leafsDao.getLeafs(root).map { map(it) }

    override suspend fun addLeaf(leaf: Leaf) = leafsDao.addLeaf(leaf.toEntity())

    private fun map(leaf: LeafEntity): Leaf = Leaf(
        id = leaf.id,
        content = leaf.content,
        isCompleted = leaf.isCompleted,
        parentId = leaf.parentId
    )

}