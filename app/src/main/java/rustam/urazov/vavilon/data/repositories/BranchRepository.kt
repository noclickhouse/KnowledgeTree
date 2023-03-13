package rustam.urazov.vavilon.data.repositories

interface BranchRepository {

    suspend fun getBranches(root: Branch): List<Branch>

}