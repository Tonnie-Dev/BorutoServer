package com.uxstate

import io.ktor.http.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlin.test.*
import io.ktor.server.testing.*

class ApplicationTest {
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

    @Test
    fun `access all heroes endpoint, assert correct information`() = testApplication {

        val response = client.get("/boruto/heroes")
        
    }


}