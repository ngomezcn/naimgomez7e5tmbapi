package com.example.example

import kotlinx.serialization.SerialName


data class LegGeometry (

  @SerialName("points" ) var points : String? = null,
  @SerialName("length" ) var length : Int?    = null

)