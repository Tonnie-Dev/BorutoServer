package com.uxstate.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.configureStatusPages(){

    //call install() ext fxn on Ktor's Application class
    this.install(StatusPages){

        //custom text whenever
        status(HttpStatusCode.NotFound) { call, status ->

            //specify custom response whenever the server sends NOT_FOUND Status
            call.respond(message = "404: Page Not Found", status = status)
        }

    }


}