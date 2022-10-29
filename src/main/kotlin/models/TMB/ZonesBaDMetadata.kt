package com.example.example

import kotlinx.serialization.SerialName


data class ZonesBaDMetadata (

  @SerialName("fromInZone" ) var fromInZone : String? = null,
  @SerialName("toInZone"   ) var toInZone   : String? = null

)