package com.uxstate.model

//This class will be returned to the client
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val previousPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList()
) {
}