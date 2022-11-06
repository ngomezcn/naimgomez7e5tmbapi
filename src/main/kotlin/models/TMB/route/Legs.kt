package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Legs (

    @SerialName("startTime"                ) var startTime                : Long?              = null,
    @SerialName("endTime"                  ) var endTime                  : Long?              = null,
    @SerialName("departureDelay"           ) var departureDelay           : Long?              = null,
    @SerialName("arrivalDelay"             ) var arrivalDelay             : Long?              = null,
    @SerialName("realTime"                 ) var realTime                 : Boolean?          = null,
    @SerialName("distance"                 ) var distance                 : Double?           = null,
    @SerialName("pathway"                  ) var pathway                  : Boolean?          = null,
    @SerialName("mode"                     ) var mode                     : String?           = null,
    @SerialName("route"                    ) var route                    : String?           = null,
    @SerialName("agencyTimeZoneOffset"     ) var agencyTimeZoneOffset     : Long?              = null,
    @SerialName("interlineWithPreviousLeg" ) var interlineWithPreviousLeg : Boolean?          = null,
    @SerialName("from"                     ) var from                     : From?             = From(),
    @SerialName("to"                       ) var to                       : To?               = To(),
    @SerialName("legGeometry"              ) var legGeometry              : LegGeometry?      = LegGeometry(),
    @SerialName("rentedBike"               ) var rentedBike               : Boolean?          = null,
    @SerialName("duration"                 ) var duration                 : Long?              = null,
    @SerialName("transitLeg"               ) var transitLeg               : Boolean?          = null,
    @SerialName("intermediateStops"        ) var intermediateStops        : ArrayList<IntermediateStops> = arrayListOf(),
    @SerialName("steps"                    ) var steps                    : ArrayList<Steps>  = arrayListOf()

)