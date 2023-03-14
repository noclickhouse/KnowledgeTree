package rustam.urazov.vavilon.usecases

import rustam.urazov.vavilon.core.interactor.UseCase
import rustam.urazov.vavilon.data.repositories.LeafModel
import rustam.urazov.vavilon.data.repositories.LeafRepository
import javax.inject.Inject

class AddLeafUseCase
@Inject constructor(
    private val leafRepository: LeafRepository
) : UseCase<Unit, LeafModel>() {

    override suspend fun run(params: LeafModel) = leafRepository.addLeaf(params)

}