package models.TMB.route

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Plan (

  //@SerialName("date"        ) var date        : Long?                   = null,
  //@SerialName("from"        ) var from        : From?                  = From(),
  //@SerialName("to"          ) var to          : To?                    = To(),
  @SerialName("itineraries" ) var itineraries : ArrayList<Itineraries> = arrayListOf()

)