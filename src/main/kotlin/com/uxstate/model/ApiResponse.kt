package com.uxstate.model

import kotlinx.serialization.Serializable


/*Parcelable convert object to byte stream and pass
the data between two processes in Android. Serialization
converts POJO to JSON and be used across platforms.

Serialization in this context enables us to send this
object as a JSON or response*/
@Serializable
//This class will be returned to the client
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val previousPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList(),
    val lastUpdated: Long? = null
) {
}