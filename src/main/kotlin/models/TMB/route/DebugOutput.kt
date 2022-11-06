package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class DebugOutput (

  @SerialName("precalculationTime"  ) var precalculationTime  : Int?           = null,
  @SerialName("pathCalculationTime" ) var pathCalculationTime : Int?           = null,
  @SerialName("pathTimes"           ) var pathTimes           : ArrayList<Int> = arrayListOf(),
  @SerialName("renderingTime"       ) var renderingTime       : Int?           = null,
  @SerialName("totalTime"           ) var totalTime           : Int?           = null,
  @SerialName("timedOut"            ) var timedOut            : Boolean?       = null

)