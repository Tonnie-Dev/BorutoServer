package com.uxstate.routes

import com.uxstate.model.ApiResponse
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun Route.getAllHeroes() {

    get(path = "/boruto/heroes") {

        try {
            //retrieve page query defaulting to 1 if null
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)
            //respond

            call.respond(message = page)
        } catch (e: NumberFormatException) {


            /*exception in Java that occurs when an attempt is made to
            convert a string with an incorrect format to a numeric value*/
            call.respond(message = ApiResponse(success = false,
                    message = "Only Numbers Allowed"), status = HttpStatusCode.BadRequest)

        } catch (e: IllegalArgumentException) {


            /*exception in Java that occurs when an attempt is made to
            convert a string with an incorrect format to a numeric value*/
            call.respond(message = ApiResponse(success = false,
                    message = "Heroes not found"), status = HttpStatusCode.BadRequest)

        }

    }

}