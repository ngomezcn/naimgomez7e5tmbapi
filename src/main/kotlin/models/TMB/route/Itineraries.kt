package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Itineraries (

    @SerialName("duration"          ) var duration          : Long?            = null,
    @SerialName("startTime"         ) var startTime         : Long?            = null,
    @SerialName("endTime"           ) var endTime           : Long?            = null,
    @SerialName("walkTime"          ) var walkTime          : Long?            = null,
    @SerialName("transitTime"       ) var transitTime       : Long?            = null,
    @SerialName("waitingTime"       ) var waitingTime       : Long?            = null,
    @SerialName("walkDistance"      ) var walkDistance      : Double?         = null,
    @SerialName("walkLimitExceeded" ) var walkLimitExceeded : Boolean?        = null,
    @SerialName("elevationLost"     ) var elevationLost     : Long?            = null,
    @SerialName("elevationGained"   ) var elevationGained   : Long?            = null,
    @SerialName("transfers"         ) var transfers         : Long?            = null,
    @SerialName("legs"              ) var legs              : ArrayList<Legs> = arrayListOf(),
    @SerialName("tooSloped"         ) var tooSloped         : Boolean?        = null

)