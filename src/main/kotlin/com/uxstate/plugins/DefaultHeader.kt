package com.uxstate.plugins

import io.ktor.http.HttpHeaders.CacheControl
import io.ktor.server.application.*
import io.ktor.server.plugins.defaultheaders.*
import java.time.Duration


fun Application.configureDefaulterHeader(){

    /*Helps to attach a custom header to each response sent
     from our server. In this case we will send one custom
     response header which will allow us to basically cache
     the data to our Android App every time we receive some
     values from the server*/

    install(DefaultHeaders){

        val oneYearInSeconds = Duration.ofDays(365).seconds

        //sent out with every response from the server to the client
        //to automatically cache data for one year
        header(name = CacheControl,
                value = "public, max-age=$oneYearInSeconds, immutable")

    }


}