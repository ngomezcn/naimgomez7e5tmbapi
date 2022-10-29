package com.example.example

import kotlinx.serialization.SerialName


data class Steps (

  @SerialName("distance"          ) var distance          : Double?           = null,
  @SerialName("relativeDirection" ) var relativeDirection : String?           = null,
  @SerialName("streetName"        ) var streetName        : String?           = null,
  @SerialName("absoluteDirection" ) var absoluteDirection : String?           = null,
  @SerialName("stayOn"            ) var stayOn            : Boolean?          = null,
  @SerialName("area"              ) var area              : Boolean?          = null,
  @SerialName("bogusName"         ) var bogusName         : Boolean?          = null,
  @SerialName("lon"               ) var lon               : Double?           = null,
  @SerialName("lat"               ) var lat               : Double?           = null,
  @SerialName("elevation"         ) var elevation         : ArrayList<String> = arrayListOf()

)