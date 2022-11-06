package ui

import BLRoutePlanner
import models.OSM.OSMPlace
import models.TMB.route.Itineraries
import models.TMB.route.Legs
import models.TMB.route.Steps
import models.TMB.route.TMBRoute
import repositories.ClientFactory
import repositories.OSMRepository
import java.util.*

// https://api.tmb.cat/v1/planner/plan?app_key=95aa927e0682dc28a7cd3c306f6cc5e8&app_id=25555beb&fromPlace=41.3755204,2.1498870&toPlace=41.422520,2.187824&mode=TRANSIT,WALK

class UI {

    private val blRoutePlanner = BLRoutePlanner()
    val scanner = Scanner(System.`in`)

    private val client = ClientFactory()
    private val osmRepository = OSMRepository(client.httpClient)

    suspend fun start() {

        println("========================================================================================")
        println("= Estos son algunos inputs que sugiero utilizarlos como demostración                   =\")                                                            =")
        println("= Salida: sagrera barcelona | Destino: Institut Tecnologic de Barcelona                =")
        println("= Salida: Seidor | Destino: Institut Tecnologic de Barcelona  )                        =")
        println("= Salida: New York | Destino: Institut Tecnologic de Barcelona                         =")
        println("========================================================================================")

        val departurePlace : OSMPlace = askDeparturePlace()
        blRoutePlanner.departurePlace = departurePlace
        println("[Dirección seleccionada] => "+departurePlace.displayName+"\n")


        val destinationPlace : OSMPlace = askDestinationPlace()
        blRoutePlanner.destinationPlace = destinationPlace
        println("[Dirección seleccionada] => "+destinationPlace.displayName+"\n")


        val routes = blRoutePlanner.getRoutes()

        if(routes!!.plan!!.itineraries.size == 0) {
            println("No se ha podido calcular una ruta con los parámetros indicados")
            return
        }
        displayRoute(selectRoute(routes!!), destinationPlace, departurePlace)
    }

    suspend fun displayRoute(selected: Itineraries, departurePlace : OSMPlace, destinationPlace: OSMPlace) {
        println("\n=== Mostrando ruta ====")

        for (leg in selected.legs) {

            when(leg.mode) {
                "SUBWAY" ->subwayLeg(leg)
                "BUS" ->busLeg(leg)
                "WALK" ->walkLeg(leg)
            }
        }
    }
    private fun busLeg(leg: Legs) {
        println("[Bus] Desde [${leg.from!!.name} linea ${leg.route}], hasta la parada [${leg.to?.name} linea ${leg.route}] (${leg.duration?.div(60)} mins)")
    }
    private fun walkLeg(leg: Legs) {
        println("[Caminando] Desde [${leg.from!!.name}], hasta [${leg.to?.name}] (${leg.duration?.div(60)} mins y ${leg.distance?.toInt()} metros)")

        for (detail in leg.steps) {
            walkLegDetail(detail)
        }
    }

    private fun walkLegDetail(detail: Steps) {
        println("---- Camine dirección ${detail.absoluteDirection!!.toLowerCase()} hasta el final de la calle (${detail.distance!!.toInt()} metros)")
    }

    private fun subwayLeg(leg: Legs) {
        println("[Metro] Desde [${leg.from!!.name} linea ${leg.route}], hasta la parada [${leg.to?.name} linea ${leg.route}] (${leg.duration?.div(60)} mins)")
    }

    private fun selectRoute(routes: TMBRoute): Itineraries  {
        val itineraries = routes.plan!!.itineraries

        println("Elige una ruta:")
        for (i in itineraries.indices) {
            println("${i}.- Duración ${(itineraries[i].duration?.div(60)).toString()} minutos, Distancia caminando: ${itineraries[i].walkDistance!!.toInt()} metros")
        }

        print("=> ")
        return itineraries[scanner.nextLine().toInt()]
    }

    private suspend fun askDeparturePlace() : OSMPlace {

        var place = OSMPlace()
        print("Indique la dirección de salida (dentro del área metropolitana de Barcelona): ")
        var departureName = scanner.nextLine()

        var findedPlaces : List<OSMPlace> = osmRepository.getPlacesByName(departureName)

        while (findedPlaces.isEmpty()) {
            print("No se ha encontrado ningun lugar con el nombre [$departureName], vuelva a indicar la dirección\n=> ")
            departureName = scanner.nextLine()
            findedPlaces = osmRepository.getPlacesByName(departureName)
        }

        if (findedPlaces.size > 1) {
            println("Cuál de las siguientes direcciones es la indicada?")

            for (i in findedPlaces.indices) {
                println(i.toString() + ".- " + findedPlaces[i].displayName)
            }
            print("=> ")

            val selectedPlace = scanner.nextLine().toInt()
            return findedPlaces[selectedPlace]

        } else {
            return findedPlaces[0]
        }
    }

    private suspend fun askDestinationPlace(): OSMPlace {
        var place = OSMPlace()

        print("Indique la dirección de llegada (dentro del área metropolitana de Barcelona): ")
        var destinationName = scanner.nextLine()

        var findedPlaces : List<OSMPlace> = osmRepository.getPlacesByName(destinationName)

        while (findedPlaces.isEmpty()) {
            print("No se ha encontrado ningún lugar con el nombre [$destinationName], vuelva a indicar la dirección\n=> ")
            destinationName = scanner.nextLine()
            findedPlaces = osmRepository.getPlacesByName(destinationName)
        }

        if (findedPlaces.size > 1) {
            println("Cuál de las siguientes direcciones es la indicada? ")

            for (i in findedPlaces.indices) {
                println(i.toString() + ".- " + findedPlaces[i].displayName)
            }

            val selectedPlace = scanner.nextLine().toInt()
            return findedPlaces[selectedPlace]

        } else {
            return findedPlaces[0]
        }
    }
}

