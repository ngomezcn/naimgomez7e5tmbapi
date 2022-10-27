import com.example.example.OSMPlace
import repositories.ClientFactory
import repositories.OSMRepository
import repositories.TMBPlanner

enum class FindedPlaces {
    NONE, ONE, MANY
}

class BLRoutePlanner {

    private val client = ClientFactory()

    private val osmRepository = OSMRepository(client.httpClient)
    private val tmbPlanner = TMBPlanner(client.httpClient)

    // Bussines logic variables
    var departureName: String = ""
    var destinationName: String = ""

    var departurePlace: OSMPlace? = null
        set(value) {
            field = value
        }
    var destinationPlace: OSMPlace? = null
        set(value) {
            field = value
        }

    suspend fun planRoute() {

        val destinationPlace = osmRepository.getPlacesByName(destinationName)
        if(destinationPlace.size > 1) {

        }
    }
}