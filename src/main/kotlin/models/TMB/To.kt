package com.example.example

import kotlinx.serialization.SerialName


data class To (

  @SerialName("name"         ) var name         : String? = null,
  @SerialName("stopId"       ) var stopId       : String? = null,
  @SerialName("stopCode"     ) var stopCode     : String? = null,
  @SerialName("lon"          ) var lon          : Double? = null,
  @SerialName("lat"          ) var lat          : Double? = null,
  @SerialName("arrival"      ) var arrival      : Int?    = null,
  @SerialName("departure"    ) var departure    : Int?    = null,
  @SerialName("stopIndex"    ) var stopIndex    : Int?    = null,
  @SerialName("stopSequence" ) var stopSequence : Int?    = null,
  @SerialName("vertexType"   ) var vertexType   : String? = null

)