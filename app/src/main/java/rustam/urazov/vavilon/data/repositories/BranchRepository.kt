package rustam.urazov.vavilon.data.repositories

interface BranchRepository {

    suspend fun getBranches(root: Int?): List<Branch>

    suspend fun addBranch(branch: Branch)

}