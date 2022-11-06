import models.Coordinates
import models.OSM.OSMPlace
import models.TMB.route.TMBRoute
import repositories.ClientFactory
import repositories.TMBRepository

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



}