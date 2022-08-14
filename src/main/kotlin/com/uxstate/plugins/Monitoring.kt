package com.uxstate.plugins

import io.ktor.server.plugins.callloging.*
import org.slf4j.event.*
import io.ktor.server.request.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureMonitoring() {

    //callLogging with the default settum
    install(CallLogging) /*{
        level = Level.INFO
        filter { call -> call.request.path().startsWith("/") }
    }*/

}
