package com.uxstate

import io.ktor.server.application.*
import com.uxstate.plugins.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {

    //plugins
    configureSerialization()
    configureMonitoring()
    configureRouting()
}
