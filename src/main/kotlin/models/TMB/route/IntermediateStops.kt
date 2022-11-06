package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class IntermediateStops (

    @SerialName("name"         ) var name         : String? = null,
    @SerialName("stopId"       ) var stopId       : String? = null,
    @SerialName("stopCode"     ) var stopCode     : String? = null,
    @SerialName("lon"          ) var lon          : Double? = null,
    @SerialName("lat"          ) var lat          : Double? = null,
    @SerialName("arrival"      ) var arrival      : Long?    = null,
    @SerialName("departure"    ) var departure    : Long?    = null,
    @SerialName("stopIndex"    ) var stopIndex    : Int?    = null,
    @SerialName("stopSequence" ) var stopSequence : Int?    = null,
    @SerialName("vertexType"   ) var vertexType   : String? = null
)