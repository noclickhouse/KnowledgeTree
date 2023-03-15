package rustam.urazov.vavilon.usecases

import rustam.urazov.vavilon.core.interactor.UseCase
import rustam.urazov.vavilon.data.repositories.BranchModel
import rustam.urazov.vavilon.data.repositories.BranchRepository
import javax.inject.Inject

class GetBranchesUseCase
 constructor(
    private val branchRepository: BranchRepository
) : UseCase<List<BranchModel>, Int>() {

    override suspend fun run(params: Int): List<BranchModel> = branchRepository.getBranches(params)

}