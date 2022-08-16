package com.uxstate.plugins

import io.ktor.server.application.*

fun Application.configureStatusPages(){

    //call install() ext fxn on Ktor's Application class

    this.install(StatusP)
}