package repositories

import models.TMB.route.TMBRoute
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import models.Coordinates

class TMBRepository(private val httpClient: HttpClient) {

    //https://api.tmb.cat/v1/planner/plan?app_id=25555beb&app_key=95aa927e0682dc28a7cd3c306f6cc5e8&fromPlace=41.3755204,2.1498870&toPlace=41.422520,2.187824&mode=

    private val appId = "25555beb"
    private val appKey = "95aa927e0682dc28a7cd3c306f6cc5e8"
    private val baseEndPoint = "https://api.tmb.cat/v1/planner/plan?app_id=$appId&app_key=$appKey"
    val query = mutableListOf<String>(baseEndPoint)

    fun setRoute(fromPlace: Coordinates, toPlace: Coordinates) {
        query.add("&fromPlace=$fromPlace&toPlace=$toPlace")
    }

    fun setMaxWalkDistance(distance: Int) {
        query.add("&maxWalkDistance=${distance.toInt()}")
    }
    fun addUsingTransit() {
        query.add("&mode=TRANSIT,WALK")
    }

    suspend fun planRoute(): TMBRoute? {

        return try {
            val tmbRoute : TMBRoute = httpClient.get(query.joinToString("")).body()
            tmbRoute
        } catch (e: Exception) {

            val error : Error = httpClient.get(query.joinToString("")).body()
            null
        }
    }
}