package ui

import BLRoutePlanner
import models.OSM.OSMPlace
import repositories.ClientFactory
import repositories.OSMRepository

// https://api.tmb.cat/v1/planner/plan?app_key=95aa927e0682dc28a7cd3c306f6cc5e8&app_id=25555beb&fromPlace=41.3755204,2.1498870&toPlace=41.422520,2.187824&mode=TRANSIT,WALK

class UI {

    private val blRoutePlanner = BLRoutePlanner()

    private val client = ClientFactory()
    private val osmRepository = OSMRepository(client.httpClient)

    suspend fun start() {

        val departurePlace : OSMPlace = askDeparturePlace()
        printAddressOfPlace(departurePlace)
        blRoutePlanner.departurePlace = departurePlace

        val destinationPlace : OSMPlace = askDestinationPlace()
        blRoutePlanner.departurePlace = destinationPlace
        printAddressOfPlace(destinationPlace)


    }

    private suspend fun askDestinationPlace(): OSMPlace {
        var place = OSMPlace()

        println("Indique direccion de llegada")
        var departureName = "seidor"; // ASK USER

        var findedPlaces : List<OSMPlace> = osmRepository.getPlacesByName(departureName)

        while (findedPlaces.isEmpty()) {
            println("No se ha encontrado ningun lugar con el nombre $departureName, vuelva a indicar la direccion")
            departureName = "institut tecnologic de barcelona";
            findedPlaces = osmRepository.getPlacesByName(departureName)
        }

        if (findedPlaces.size > 1) {
            println("Cual de las siguientes direcciones es la indicada?")

            for (i in findedPlaces) {
                printAddressOfPlace(i)
            }

            val selectedPlace = 0 // ASK USER
            place = findedPlaces[selectedPlace]

        } else {
            place = findedPlaces[0]
        }

        return place
    }

    private suspend fun askDeparturePlace() : OSMPlace {

        var place = OSMPlace()

        println("Indique direccion de salida")
        var departureName = "institut tecnologic de barcelona"; // ASK USER

        var findedPlaces : List<OSMPlace> = osmRepository.getPlacesByName(departureName)

        while (findedPlaces.isEmpty()) {
            println("No se ha encontrado ningun lugar con el nombre $departureName, vuelva a indicar la direccion")
            departureName = "institut tecnologic de barcelona";
            findedPlaces = osmRepository.getPlacesByName(departureName)
        }

        if (findedPlaces.size > 1) {
            println("Cual de las siguientes direcciones es la indicada?")

            val selectedPlace = 0 // ASK USER
            place = findedPlaces[selectedPlace]
        } else {
            place = findedPlaces[0]
        }

        return place
    }

    private fun printAddressOfPlace(place: OSMPlace) {
        println("${place.address?.city}, " +
                "${place.address?.county},  " +
                "${place.address?.state},  " +
                "${place.address?.stateDistrict},  " +
                "${place.address?.neighbourhood},  " +
                "${place.address?.road},  " +
                "${place.address?.postcode},  " +
                "${place.address?.amenity},  " +
                "${place.address?.country},  " +
                "${place.address?.countryCode},  " +
                "${place.address?.postcode}")

    }
}

