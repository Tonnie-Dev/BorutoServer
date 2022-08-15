package com.uxstate.plugins

import com.uxstate.routes.getAllHeroes
import com.uxstate.routes.root
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {

    routing {
        this.root()
        this.getAllHeroes()
    }
}
