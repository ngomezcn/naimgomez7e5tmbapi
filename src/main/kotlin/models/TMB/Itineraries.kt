package com.example.example

import kotlinx.serialization.SerialName


data class Itineraries (

  @SerialName("duration"          ) var duration          : Int?            = null,
  @SerialName("startTime"         ) var startTime         : Int?            = null,
  @SerialName("endTime"           ) var endTime           : Int?            = null,
  @SerialName("walkTime"          ) var walkTime          : Int?            = null,
  @SerialName("transitTime"       ) var transitTime       : Int?            = null,
  @SerialName("waitingTime"       ) var waitingTime       : Int?            = null,
  @SerialName("walkDistance"      ) var walkDistance      : Double?         = null,
  @SerialName("walkLimitExceeded" ) var walkLimitExceeded : Boolean?        = null,
  @SerialName("elevationLost"     ) var elevationLost     : Int?            = null,
  @SerialName("elevationGained"   ) var elevationGained   : Int?            = null,
  @SerialName("transfers"         ) var transfers         : Int?            = null,
  @SerialName("legs"              ) var legs              : ArrayList<Legs> = arrayListOf(),
  @SerialName("tooSloped"         ) var tooSloped         : Boolean?        = null

)