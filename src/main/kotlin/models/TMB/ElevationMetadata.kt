package com.example.example

import kotlinx.serialization.SerialName


data class ElevationMetadata (

  @SerialName("ellipsoidToGeoidDifference" ) var ellipsoidToGeoidDifference : Double?  = null,
  @SerialName("geoidElevation"             ) var geoidElevation             : Boolean? = null

)