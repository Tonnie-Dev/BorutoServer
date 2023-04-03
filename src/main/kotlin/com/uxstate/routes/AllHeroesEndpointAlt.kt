package com.uxstate.routes

import com.uxstate.model.ApiResponse
import com.uxstate.repository.HeroRepository
import com.uxstate.repository.HeroRepositoryAlt
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun Route.getAllHeroesAlt() {

    //inject heroRepository - it will automatically find the impl from coin

    val repository: HeroRepositoryAlt by inject()

    get(path = "/boruto/heroes") {

        try {
            //this endpoint accepts a query parameter

            //retrieve page query defaulting to 1 if null
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            val limit = call.request.queryParameters["limit"]?.toInt() ?: 4
            //require(page in 1..5) //not required in this case

            //respond
            val response = repository.getAllHeroes(page, limit)

            call.respond(message = response, status = HttpStatusCode.OK)

        } catch (e: NumberFormatException) {

            /*exception in Java that occurs when an attempt is made to
            convert a string with an incorrect format to a numeric value*/
            call.respond(message = ApiResponse(success = false,
                    message = "Only Numbers Allowed"),
                    status = HttpStatusCode.BadRequest)

        }
        //catch error thrown at require(){}
        catch (e: IllegalArgumentException) {

            /* call.respond(message = ApiResponse(success = false,
                     message = "Heroes not found"),
                     status = HttpStatusCode.NotFound)*/

            call.respond(message = ApiResponse(success = false,
                    message = "Heroes not found"),
                    status = HttpStatusCode.NotFound)

        }
    }


}