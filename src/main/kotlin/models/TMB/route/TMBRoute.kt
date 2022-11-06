package models.TMB.route

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class TMBRoute (

    @SerialName("requestParameters" ) var requestParameters : RequestParameters? = RequestParameters(),
    @SerialName("plan"              ) var plan              : Plan?              = Plan(),
  //@SerialName("debugOutput"       ) var debugOutput       : DebugOutput?       = DebugOutput(),
  //@SerialName("elevationMetadata" ) var elevationMetadata : ElevationMetadata? = ElevationMetadata(),
  //@SerialName("zonesBaDMetadata"  ) var zonesBaDMetadata  : ZonesBaDMetadata?  = ZonesBaDMetadata()
)