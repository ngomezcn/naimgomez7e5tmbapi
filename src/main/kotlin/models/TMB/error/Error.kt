package models.TMB.error

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Error (

    @SerialName("status" ) var status : String? = null,
    @SerialName("error"  ) var error  : String? = null
)