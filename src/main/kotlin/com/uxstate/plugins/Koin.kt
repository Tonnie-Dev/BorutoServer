package com.uxstate.plugins

import com.uxstate.di.koinModule

import io.ktor.server.application.*

import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.configureKoin(  ){

    //installing koin plugin
    install(Koin){

        //initialize logger
        slf4jLogger()

        //call koin's module passing in a variable
       modules(koinModule)
    }
}