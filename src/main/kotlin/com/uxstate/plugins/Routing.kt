package com.uxstate.plugins

import com.uxstate.routes.getAllHeroes
import com.uxstate.routes.root
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {

    routing {
        this.root()
        this.getAllHeroes()
        this.ge
        static("/images"){

            resources("images")
        }


    }
}
