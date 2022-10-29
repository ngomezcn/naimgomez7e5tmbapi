package repositories

import models.OSM.OSMPlace
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class OSMRepository(private val httpClient: HttpClient) {

    public suspend fun getPlacesByName(address: String): List<OSMPlace>{

        val query = listOf("https://nominatim.openstreetmap.org/search?q=", address.replace(" ", "+"), "&format=json&polygon=1&addressdetails=1")
        val places : List<OSMPlace> = httpClient.get(query.joinToString("")).body()

        return places
    }
}