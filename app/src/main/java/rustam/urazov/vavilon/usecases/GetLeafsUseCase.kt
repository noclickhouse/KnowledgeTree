package rustam.urazov.vavilon.usecases

import rustam.urazov.vavilon.core.interactor.UseCase
import rustam.urazov.vavilon.data.repositories.LeafModel
import rustam.urazov.vavilon.data.repositories.LeafRepository
import javax.inject.Inject

class GetLeafsUseCase
 constructor(
    private val leafRepository: LeafRepository
) : UseCase<List<LeafModel>, Int>() {

    override suspend fun run(params: Int): List<LeafModel> = leafRepository.getLeafs(params)

}