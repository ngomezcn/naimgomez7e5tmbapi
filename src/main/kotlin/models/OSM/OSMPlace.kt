package models.OSM

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OSMPlace (

  @SerialName("place_id"     ) var placeId     : Int?              = null,
  @SerialName("licence"      ) var licence     : String?           = null,
  @SerialName("lat"          ) var lat         : String           = "",
  @SerialName("lon"          ) var lon         : String           = "",
  @SerialName("display_name" ) var displayName : String?           = null,
  @SerialName("type"         ) var type        : String?           = null,
  @SerialName("address"      ) var address     : OSMAddress?          = OSMAddress()
)
