package rustam.urazov.vavilon.data.repositories

import rustam.urazov.vavilon.data.repositories.storage.BranchEntity
import rustam.urazov.vavilon.data.repositories.storage.BranchesDao
import javax.inject.Inject

class BranchRepositoryImpl
@Inject constructor(
    private val branchesDao: BranchesDao
) : BranchRepository {

    override suspend fun getBranches(root: Int): List<BranchModel> =
        branchesDao.getBranches(root).map { map(it) }

    override suspend fun addBranch(branch: BranchModel) = branchesDao.addBranch(branch.toEntity())

    private fun map(branch: BranchEntity): BranchModel = BranchModel(
        id = branch.id,
        title = branch.title,
        parentId = branch.parentId
    )

}