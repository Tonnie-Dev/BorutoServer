package com.uxstate

import com.uxstate.model.ApiResponse
import com.uxstate.plugins.configureRouting
import com.uxstate.repository.HeroRepository
import io.ktor.client.call.*
import io.ktor.http.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*
import io.ktor.util.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject

class ApplicationTest {

    //inject heroRepository to access heroes list for page one
    private val repository:HeroRepository by inject(HeroRepository::class.java)
    /*@Test
    fun testRoot() = testApplication {



       application {
            configureRouting()

        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Welcome to Boruto API", bodyAsText())
        }
    }*/


    @Test
    fun `access root endpoint, assert correct info`() = testApplication {
        val response = client.get("/")
        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(expected = "\"Welcome to Boruto API\"", actual = response.bodyAsText())
    }

    @OptIn(InternalAPI::class)
    @Test
    fun `access all heroes endpoint, assert correct information`() = testApplication {

        environment {
            developmentMode = false
        }

        val response = client.get("/boruto/heroes")

        //first check the returned status code is OK

        assertEquals(expected = HttpStatusCode.OK, actual = response.status)

        val expected = ApiResponse(success =true,
                message = "OK",
                previousPage = null,
                nextPage = 2,
                heroes = repository.page1)

        //response from the server


      //val actual = Json.decodeFromString<ApiResponse>(response.content.toString())
     val actual = Json.decodeFromString<ApiResponse>(response.body())

        println("Actual isvv $actual")
        println("expected isvv $expected")

        assertEquals(expected = expected, actual = actual)
    }



    @Test
    fun `access all heroes endpoint, query all pages, assert correct information`()=
        testApplication {

            val response = client.get("/boruto/heroes")

    }
}