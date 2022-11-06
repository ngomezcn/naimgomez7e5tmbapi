package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable

data class From (

  @SerialName("name"       ) var name       : String? = null,
  @SerialName("lon"        ) var lon        : Double? = null,
  @SerialName("lat"        ) var lat        : Double? = null,
  @SerialName("departure"  ) var departure  : Long?    = null,
  @SerialName("orig"       ) var orig       : String? = null,
  @SerialName("vertexType" ) var vertexType : String? = null

)