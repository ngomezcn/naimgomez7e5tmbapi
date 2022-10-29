package com.example.example

import kotlinx.serialization.SerialName


data class From (

  @SerialName("name"       ) var name       : String? = null,
  @SerialName("lon"        ) var lon        : Double? = null,
  @SerialName("lat"        ) var lat        : Double? = null,
  @SerialName("departure"  ) var departure  : Int?    = null,
  @SerialName("orig"       ) var orig       : String? = null,
  @SerialName("vertexType" ) var vertexType : String? = null

)