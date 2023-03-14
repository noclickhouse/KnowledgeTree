package rustam.urazov.vavilon.data.repositories

interface LeafRepository {

    suspend fun getLeafs(root: Int): List<Leaf>

    suspend fun addLeaf(leaf: Leaf)

}