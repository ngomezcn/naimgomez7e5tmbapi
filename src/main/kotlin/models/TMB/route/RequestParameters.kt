package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RequestParameters (

  @SerialName("date"                            ) var date                            : String? = null,
  @SerialName("walkSpeed"                       ) var walkSpeed                       : String? = null,
  @SerialName("walkReluctance"                  ) var walkReluctance                  : String? = null,
  @SerialName("preferredRoutes"                 ) var preferredRoutes                 : String? = null,
  @SerialName("softWalkOverageRate"             ) var softWalkOverageRate             : String? = null,
  @SerialName("fromPlace"                       ) var fromPlace                       : String? = null,
  @SerialName("maxHours"                        ) var maxHours                        : String? = null,
  @SerialName("softWalkPenalty"                 ) var softWalkPenalty                 : String? = null,
  @SerialName("transferPenalty"                 ) var transferPenalty                 : String? = null,
  @SerialName("waitReluctance"                  ) var waitReluctance                  : String? = null,
  @SerialName("maxWalkDistance"                 ) var maxWalkDistance                 : String? = null,
  @SerialName("maxTransfers"                    ) var maxTransfers                    : String? = null,
  @SerialName("otherThanPreferredRoutesPenalty" ) var otherThanPreferredRoutesPenalty : String? = null,
  @SerialName("numItineraries"                  ) var numItineraries                  : String? = null,
  @SerialName("waitAtBeginningFactor"           ) var waitAtBeginningFactor           : String? = null,
  @SerialName("preferredAgencies"               ) var preferredAgencies               : String? = null,
  @SerialName("walkBoardCost"                   ) var walkBoardCost                   : String? = null,
  @SerialName("toPlace"                         ) var toPlace                         : String? = null,
  @SerialName("time"                            ) var time                            : String? = null,
  @SerialName("maxTransferWalkDistance"         ) var maxTransferWalkDistance         : String? = null

)