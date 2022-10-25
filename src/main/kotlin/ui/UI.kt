package ui

import BLRoutePlanner
import com.example.example.OSMPlace

// https://api.tmb.cat/v1/planner/plan?app_key=95aa927e0682dc28a7cd3c306f6cc5e8&app_id=25555beb&fromPlace=41.3755204,2.1498870&toPlace=41.422520,2.187824&mode=TRANSIT,WALK

class UI {

    private val blRoutePlanner = BLRoutePlanner()

    suspend fun start() {
        askDepartureName()
        askDestinationName()


    }

    private suspend fun askDepartureName() {
        val depName = "institut tecnologic de barcelona";

        val foundPlaces = blRoutePlanner.findPlaces(depName)

        if(foundPlaces.size == 1) {
            blRoutePlanner.departurePlace = foundPlaces[0]
            printAddressOfPlace(foundPlaces[0])

        } else if (foundPlaces.size > 1) {
            blRoutePlanner.departurePlace = foundPlaces[0]
            println("Cual de las siguietnes direcciones ")

        } else {
            println("No se ha encontrado ningun lugar con el nombre $depName")
        }

    }

    private fun printAddressOfPlace(place: OSMPlace) {
        println("${place.address?.city}, " +
                "${place.address?.county}  " +
                "${place.address?.state}  " +
                "${place.address?.postcode}  " +
                "${place.address?.amenity}  " +
                "${place.address?.country}  " +
                "${place.address?.countryCode}  " +
                "${place.address?.postcode}")
    }


    private fun askDestinationName() {
        //BLRoutePlanner.destinationName = "seidor carrer pujades"
    }

    private fun askSpecificAddress() {

    }
}

suspend fun main()
{
    val ui = UI()
    ui.start()
}
