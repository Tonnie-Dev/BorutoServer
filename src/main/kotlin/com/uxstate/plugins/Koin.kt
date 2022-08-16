package com.uxstate.plugins

import com.uxstate.di.koinModule

import io.ktor.server.application.*

import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin(  ){

    //installing koin plugin
    install(Koin){

        //initialize logger - Simple Logging Facade 4 Java
        slf4jLogger()

        //call koin's module passing in a module variable
       modules(koinModule)
    }
}