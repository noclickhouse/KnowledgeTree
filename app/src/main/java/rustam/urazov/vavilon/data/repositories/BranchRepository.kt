package rustam.urazov.vavilon.data.repositories

interface BranchRepository {

    suspend fun getBranches(root: Int): List<BranchModel>

    suspend fun addBranch(branch: BranchModel)

    suspend fun updateBranch(branch: BranchModel)

}