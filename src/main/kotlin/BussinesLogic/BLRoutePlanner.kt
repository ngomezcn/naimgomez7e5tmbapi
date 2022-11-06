import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import models.Coordinates
import models.OSM.OSMPlace
import models.TMB.route.Itineraries
import models.TMB.route.TMBRoute
import repositories.ClientFactory
import repositories.TMBRepository
import java.io.File
import java.nio.file.Path

enum class FindedPlaces {
    NONE, ONE, MANY
}
class BLRoutePlanner {

    private val client = ClientFactory()

    private val tmbRepository = TMBRepository(client.httpClient)

    var departurePlace: OSMPlace? = null
    var destinationPlace: OSMPlace? = null

    suspend fun getRoutes(): TMBRoute?   {

        if(departurePlace != null && destinationPlace != null) {

            tmbRepository.setRoute(fromPlace=Coordinates(departurePlace!!.lat, departurePlace!!.lon), toPlace=Coordinates(destinationPlace!!.lat, destinationPlace!!.lon))
            tmbRepository.setMaxWalkDistance(800)
            tmbRepository.addUsingTransit()

            val route = tmbRepository.planRoute()

            return route
        }

        return null
    }

    val saved_routes = "saved_routes.json"
    private fun readSavedRoutes(): List<Itineraries> {
        val file = File(saved_routes)

        if(!file.exists()) {
            val json = Json.encodeToString(listOf<Itineraries>())
            File(saved_routes).writeText(json)
        }

        return Json.decodeFromString<List<Itineraries>>( file.readText(Charsets.UTF_8))
    }


    fun saveRoute(selected: Itineraries) {

        val list : MutableList<Itineraries> = readSavedRoutes() as MutableList<Itineraries>
        list.add(selected)

        val json = Json.encodeToString(list)
        File(saved_routes).writeText(json)
    }


}