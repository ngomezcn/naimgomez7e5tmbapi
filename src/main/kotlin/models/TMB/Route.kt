package com.example.example

import kotlinx.serialization.SerialName


data class Route (

  @SerialName("requestParameters" ) var requestParameters : RequestParameters? = RequestParameters(),
  @SerialName("plan"              ) var plan              : Plan?              = Plan(),
  @SerialName("debugOutput"       ) var debugOutput       : DebugOutput?       = DebugOutput(),
  @SerialName("elevationMetadata" ) var elevationMetadata : ElevationMetadata? = ElevationMetadata(),
  @SerialName("zonesBaDMetadata"  ) var zonesBaDMetadata  : ZonesBaDMetadata?  = ZonesBaDMetadata()

)