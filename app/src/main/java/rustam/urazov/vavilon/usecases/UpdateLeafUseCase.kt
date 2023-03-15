package rustam.urazov.vavilon.usecases

import rustam.urazov.vavilon.core.interactor.UseCase
import rustam.urazov.vavilon.data.repositories.LeafModel
import rustam.urazov.vavilon.data.repositories.LeafRepository
import javax.inject.Inject

class UpdateLeafUseCase
 constructor(
    private val leafRepository: LeafRepository
) : UseCase<Unit, LeafModel>() {

    override suspend fun run(params: LeafModel) = leafRepository.updateLeaf(params)

}