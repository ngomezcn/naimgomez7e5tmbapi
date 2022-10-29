package com.example.example

import kotlinx.serialization.SerialName


data class Plan (

  @SerialName("date"        ) var date        : Int?                   = null,
  @SerialName("from"        ) var from        : From?                  = From(),
  @SerialName("to"          ) var to          : To?                    = To(),
  @SerialName("itineraries" ) var itineraries : ArrayList<Itineraries> = arrayListOf()

)