package com.uxstate.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*

fun Application.configureStatusPages(){

    //call install() ext fxn on Ktor's Application class

    this.install(StatusPages)
}