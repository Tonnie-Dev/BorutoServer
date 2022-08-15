package com.uxstate.model

import kotlinx.serialization.Serializable

//we will not be returning this data class directly

/*Parcelable converts object to byte stream and pass
the data between two process in Android. Serialization
converts POJO to JSON and be used across platforms*/
@Serializable
data class Hero(
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val rating: Double,
    val power: Int,
    val month: String,
    val day: String,
    val family: List<String>,
    val abilities: List<String>,
    val natureTypes: List<String>
)
