package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class LegGeometry (

  @SerialName("points" ) var points : String? = null,
  @SerialName("length" ) var length : Int?    = null

)