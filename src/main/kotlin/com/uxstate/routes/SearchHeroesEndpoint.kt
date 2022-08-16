package com.uxstate.routes

import com.uxstate.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

import org.koin.ktor.ext.inject
fun Route.searchHeroes(){

    //inject repository outside get
    val repository:HeroRepository by inject()

    get ("/boruto/heroes/search"){




        //takes one query parameter

        val name = call.request.queryParameters["name"] 

        call.respond(message = repository.searchHeroes(name), status = HttpStatusCode.OK)

    }
}