package com.uxstate.routes

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Route.searchHeroes(){


    get ("/boruto/heroes/search"){


        //takes one query paramenter

        val name = call.request.queryParameters["name"] ?: "name"
    }
}