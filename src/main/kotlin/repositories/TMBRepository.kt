package repositories

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import models.OSM.OSMPlace

data class Coordinates(val latitude: String, val longitude: String) {

    override fun toString() : String {
        return "$latitude,$longitude"
    }
}

class TMBRepository(private val httpClient: HttpClient) {

    private val appId = "25555beb"
    private val appKey = "95aa927e0682dc28a7cd3c306f6cc5e8"
    private val baseEndPoint = "https://api.tmb.cat/v1/planner/plan?app_id=$appId&app_key=$appKey"
    private val query = mutableListOf<String>(baseEndPoint)

    //https://api.tmb.cat/v1/planner/plan?app_id=25555beb&app_key=95aa927e0682dc28a7cd3c306f6cc5e8&fromPlace=41.3755204,2.1498870&toPlace=41.422520,2.187824
    // Request parameters
    val fromPlace: String = ""
    val toPlace: String = ""
    val mode: String = ""

    fun setCoordinates(fromPlace: Coordinates, toPlace: Coordinates) {
        query.add("&fromPlace=$fromPlace&toPlace=$toPlace")
    }


    public suspend fun planRoute(): List<OSMPlace>{

        val places : List<OSMPlace> = httpClient.get(query.joinToString("")).body()

        return places
    }
}