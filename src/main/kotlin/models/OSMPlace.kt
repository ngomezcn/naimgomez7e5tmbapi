package com.example.example

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.OSMAddress

@Serializable
data class OSMPlace (

  @SerialName("place_id"     ) var placeId     : Int?              = null,
  @SerialName("licence"      ) var licence     : String?           = null,
  @SerialName("lat"          ) var lat         : String?           = null,
  @SerialName("lon"          ) var lon         : String?           = null,
  @SerialName("display_name" ) var displayName : String?           = null,
  @SerialName("type"         ) var type        : String?           = null,
  @SerialName("address"      ) var address     : OSMAddress?          = OSMAddress()
)
