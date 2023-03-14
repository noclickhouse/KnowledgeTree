package rustam.urazov.vavilon.core.interactor

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Type

    class None()
}