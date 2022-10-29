import models.OSM.OSMPlace
import repositories.ClientFactory
import repositories.OSMRepository
import repositories.TMBPlanner

enum class FindedPlaces {
    NONE, ONE, MANY
}
class BLRoutePlanner {

    private val client = ClientFactory()

    private val tmbPlanner = TMBPlanner(client.httpClient)

    var departurePlace: OSMPlace? = null
    var destinationPlace: OSMPlace? = null

    suspend fun planRoute() {

    }
}