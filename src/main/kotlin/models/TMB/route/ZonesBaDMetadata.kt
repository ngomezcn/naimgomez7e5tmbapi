package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ZonesBaDMetadata (

    @SerialName("fromInZone" ) var fromInZone : FromInZone? = FromInZone(),
    @SerialName("toInZone"   ) var toInZone   : String? = null

)
@kotlinx.serialization.Serializable
data class toInZone (

  @SerialName("codiLinia"   ) var codiLinia   : Int?    = null,
  @SerialName("nomLinia"    ) var nomLinia    : String? = null,
  @SerialName("descLinia"   ) var descLinia   : String? = null,
  @SerialName("geometry"    ) var geometry    : String? = null,
  @SerialName("nearestStop" ) var nearestStop : String? = null
)

@kotlinx.serialization.Serializable
data class fromInZone (

  @SerialName("codiLinia"   ) var codiLinia   : Int?    = null,
  @SerialName("nomLinia"    ) var nomLinia    : String? = null,
  @SerialName("descLinia"   ) var descLinia   : String? = null,
  @SerialName("geometry"    ) var geometry    : String? = null,
  @SerialName("nearestStop" ) var nearestStop : String? = null
)