package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class FromInZone (

    @SerialName("codiLinia"   ) var codiLinia   : Int?    = null,
    @SerialName("nomLinia"    ) var nomLinia    : String? = null,
    @SerialName("descLinia"   ) var descLinia   : String? = null,
    @SerialName("geometry"    ) var geometry    : String? = null,
    @SerialName("nearestStop" ) var nearestStop : String? = null
)