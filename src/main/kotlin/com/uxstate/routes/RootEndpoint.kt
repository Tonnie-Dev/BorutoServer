package com.uxstate.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//The root() ext function will be called from Routing plugin
fun Route.root(){
//root endpoint

    get(path = "/"){

        call.respond(message = "Welcome to Boruto API", status =
        HttpStatusCode.OK)
    }

}