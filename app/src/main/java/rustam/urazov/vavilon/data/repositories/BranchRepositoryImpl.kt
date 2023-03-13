package rustam.urazov.vavilon.data.repositories

class BranchRepositoryImpl(
    private val branchService: BranchService
) : BranchRepository {

    override suspend fun getBranches(root: Branch): List<Branch> = branchService.getBranches(root)

}