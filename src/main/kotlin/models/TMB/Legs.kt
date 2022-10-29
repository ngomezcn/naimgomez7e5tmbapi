package com.example.example

import kotlinx.serialization.SerialName


data class Legs (

  @SerialName("startTime"                ) var startTime                : Int?              = null,
  @SerialName("endTime"                  ) var endTime                  : Int?              = null,
  @SerialName("departureDelay"           ) var departureDelay           : Int?              = null,
  @SerialName("arrivalDelay"             ) var arrivalDelay             : Int?              = null,
  @SerialName("realTime"                 ) var realTime                 : Boolean?          = null,
  @SerialName("distance"                 ) var distance                 : Double?           = null,
  @SerialName("pathway"                  ) var pathway                  : Boolean?          = null,
  @SerialName("mode"                     ) var mode                     : String?           = null,
  @SerialName("route"                    ) var route                    : String?           = null,
  @SerialName("agencyTimeZoneOffset"     ) var agencyTimeZoneOffset     : Int?              = null,
  @SerialName("interlineWithPreviousLeg" ) var interlineWithPreviousLeg : Boolean?          = null,
  @SerialName("from"                     ) var from                     : From?             = From(),
  @SerialName("to"                       ) var to                       : To?               = To(),
  @SerialName("legGeometry"              ) var legGeometry              : LegGeometry?      = LegGeometry(),
  @SerialName("rentedBike"               ) var rentedBike               : Boolean?          = null,
  @SerialName("duration"                 ) var duration                 : Int?              = null,
  @SerialName("transitLeg"               ) var transitLeg               : Boolean?          = null,
  @SerialName("intermediateStops"        ) var intermediateStops        : ArrayList<String> = arrayListOf(),
  @SerialName("steps"                    ) var steps                    : ArrayList<Steps>  = arrayListOf()

)