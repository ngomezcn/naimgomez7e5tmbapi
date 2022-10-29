package com.example.example

import kotlinx.serialization.SerialName


data class DebugOutput (

  @SerialName("precalculationTime"  ) var precalculationTime  : Int?           = null,
  @SerialName("pathCalculationTime" ) var pathCalculationTime : Int?           = null,
  @SerialName("pathTimes"           ) var pathTimes           : ArrayList<Int> = arrayListOf(),
  @SerialName("renderingTime"       ) var renderingTime       : Int?           = null,
  @SerialName("totalTime"           ) var totalTime           : Int?           = null,
  @SerialName("timedOut"            ) var timedOut            : Boolean?       = null

)