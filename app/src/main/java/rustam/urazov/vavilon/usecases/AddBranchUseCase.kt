package rustam.urazov.vavilon.usecases

import rustam.urazov.vavilon.core.interactor.UseCase
import rustam.urazov.vavilon.data.repositories.BranchModel
import rustam.urazov.vavilon.data.repositories.BranchRepository
import javax.inject.Inject

class AddBranchUseCase
 constructor(
    private val branchRepository: BranchRepository
) : UseCase<Unit, BranchModel>() {

    override suspend fun run(params: BranchModel): Unit = branchRepository.addBranch(params)

}