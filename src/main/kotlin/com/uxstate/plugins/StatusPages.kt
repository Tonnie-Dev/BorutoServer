package com.uxstate.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import java.lang.IllegalArgumentException

fun Application.configureStatusPages(){

    //call install() ext fxn on Ktor's Application class
    this.install(StatusPages){

        //custom text whenever
        status(HttpStatusCode.NotFound) { call, status ->

            //specify custom response whenever the server sends NOT_FOUND Status
            call.respond(message = "404: Page Not Found", status = status)
        }


        //whenever the specified exception is caught, the below code is triggered to respond with
              // a custom message
        exception<IllegalArgumentException>(){

            call, _ ->

            call.respond(message = "exception caught", status = HttpStatusCode.BadRequest)
        }



    }


}