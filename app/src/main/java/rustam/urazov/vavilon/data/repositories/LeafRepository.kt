package rustam.urazov.vavilon.data.repositories

interface LeafRepository {

    suspend fun getLeafs(root: Int): List<LeafModel>

    suspend fun addLeaf(leaf: LeafModel)

}