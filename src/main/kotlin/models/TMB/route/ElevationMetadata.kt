package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ElevationMetadata (

  @SerialName("ellipsoidToGeoidDifference" ) var ellipsoidToGeoidDifference : Double?  = null,
  @SerialName("geoidElevation"             ) var geoidElevation             : Boolean? = null

)