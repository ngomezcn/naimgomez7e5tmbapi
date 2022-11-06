package repositories

import models.Coordinates
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TMBRepositoryTest {

    // TESTING THE QUERY BUILD

    private val client = ClientFactory()

    @Test
    fun setRoute() {
        val tmbRepository = TMBRepository(client.httpClient)
        tmbRepository.setRoute(Coordinates("1", "2"), Coordinates("1", "2"))

        val result = tmbRepository.query.joinToString("")
        val expected = "https://api.tmb.cat/v1/planner/plan?app_id=25555beb&app_key=95aa927e0682dc28a7cd3c306f6cc5e8&fromPlace=1,2&toPlace=1,2"

        assertEquals(expected, result)
    }

    @Test
    fun setMaxWalkDistance() {
        val tmbRepository = TMBRepository(client.httpClient)
        tmbRepository.setMaxWalkDistance(1234)

        val result = tmbRepository.query.joinToString("")
        val expected = "https://api.tmb.cat/v1/planner/plan?app_id=25555beb&app_key=95aa927e0682dc28a7cd3c306f6cc5e8&maxWalkDistance=1234"

        assertEquals(expected, result)
    }

    @Test
    fun addUsingTransit() {
        val tmbRepository = TMBRepository(client.httpClient)
        tmbRepository.addUsingTransit()

        val result = tmbRepository.query.joinToString("")
        val expected = "https://api.tmb.cat/v1/planner/plan?app_id=25555beb&app_key=95aa927e0682dc28a7cd3c306f6cc5e8&mode=TRANSIT,WALK"

        assertEquals(expected, result)
    }
}