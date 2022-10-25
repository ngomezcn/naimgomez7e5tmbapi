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

    lateinit var departurePlace: OSMPlace
    lateinit var destinationPlace: OSMPlace

    suspend fun findPlaces(departureName: String) : List<OSMPlace> {
        val departurePlaces : List<OSMPlace> = osmRepository.getPlacesByName(departureName)
        return departurePlaces
        /*return if(departurePlaces.size == 1) {
            departurePlace = departurePlaces[0]
            FindedPlaces.ONE
        } else if (departurePlaces.size > 1) {
            FindedPlaces.MANY
        } else {
            FindedPlaces.NONE
        }*/
    }

    suspend fun planRoute() {



        val destinationPlace = osmRepository.getPlacesByName(destinationName)
        if(destinationPlace.size > 1) {

        }
    }

    suspend fun askUserSpecificAddress() {

    }
}