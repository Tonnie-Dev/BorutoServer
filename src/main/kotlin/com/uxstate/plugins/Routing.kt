package com.uxstate.plugins

import com.uxstate.routes.getAllHeroes
import com.uxstate.routes.getAllHeroesAlt
import com.uxstate.routes.root
import com.uxstate.routes.searchHeroes
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*

fun Application.configureRouting() {

    routing {
        this.root()
       // this.getAllHeroes()
        this.getAllHeroesAlt()
        this.searchHeroes()
        static("/images") {

            resources("images")
        }

        get("/test") {

            throw IllegalAccessException()
        }

    }
}
