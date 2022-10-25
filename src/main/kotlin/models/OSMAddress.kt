package models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OSMAddress (
  @SerialName("amenity"        ) var amenity        : String? = null,
  @SerialName("road"           ) var road           : String? = null,
  @SerialName("neighbourhood"  ) var neighbourhood  : String? = null,
  @SerialName("city"           ) var city           : String? = null,
  @SerialName("county"         ) var county         : String? = null,
  @SerialName("state_district" ) var stateDistrict  : String? = null,
  @SerialName("state"          ) var state          : String? = null,
  @SerialName("postcode"       ) var postcode       : String? = null,
  @SerialName("country"        ) var country        : String? = null,
  @SerialName("country_code"   ) var countryCode    : String? = null
)