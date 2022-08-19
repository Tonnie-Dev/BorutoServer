package com.uxstate

import com.uxstate.model.ApiResponse
import com.uxstate.model.Hero
import com.uxstate.plugins.configureKoin
import com.uxstate.repository.HeroRepository
import com.uxstate.repository.NEXT_PAGE_KEY
import com.uxstate.repository.PREV_PAGE_KEY
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.utils.EmptyContent.status
import io.ktor.http.*
import io.ktor.server.testing.*
import io.ktor.util.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.koin.java.KoinJavaComponent.inject
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    //inject heroRepository to access heroes list for page one
    private val repository: HeroRepository by inject(HeroRepository::class.java)


    /*@BeforeTest
    fun setup() = testApplication {


        application {
            configureKoin()

        }


    }*/


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

        environment {
            developmentMode = false
        }

        //list of pages
        //   val heroes = repository.page1
        val response = client.get("/boruto/heroes")

        //first check the returned status code is OK

        assertEquals(expected = HttpStatusCode.OK, actual = response.status)

        val expected = ApiResponse(success = true,
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
    fun `access all heroes endpoint, query all pages, assert correct information`() =
        testApplication {
            environment {
                developmentMode = false
            }

            //range
            val pages = 1..5


            pages.forEach { page ->

                val response = client.get("/boruto/heroes?page=${page}")


                println("CURRENT PAGE: $page")
                assertEquals(expected = HttpStatusCode.OK, actual = response.status)

                val expected = ApiResponse(success = true,
                        message = "OK",
                        previousPage = calculatePageNumber(page)[PREV_PAGE_KEY],
                        nextPage = calculatePageNumber(page)[NEXT_PAGE_KEY],
                        heroes = listOf(repository.page1, repository.page2, repository.page3,
                                repository.page4, repository.page5)[page - 1])

                val actual = Json.decodeFromString<ApiResponse>(response.body())
                println("PREV PAGE: ${calculatePageNumber(page)[PREV_PAGE_KEY]}")
                println("NEXT PAGE: ${calculatePageNumber(page)[NEXT_PAGE_KEY]}")
                println("HEROES: ${
                    listOf(repository.page1, repository.page2, repository.page3,
                            repository.page4, repository.page5)[page - 1]
                }")
                assertEquals(expected = expected, actual = actual)

            }


        }


    @OptIn(InternalAPI::class)
    @Test
    fun `access all heroes endpoint, query non existent page number, assert error`() =
        testApplication {

            val response = client.get("/boruto/heroes?page=10")

            assertEquals(expected = HttpStatusCode.NotFound, actual = response.status)
/*
            val expected = ApiResponse(success = false,
                    message = "Heroes not found")
            val actual = Json.decodeFromString<ApiResponse>(response.content.toString())*/

           assertEquals(expected = "\"404: Page Not Found\"", actual  = response.body())

        }



    @Test
    fun `access all heroes endpoint, query non string page number, assert error`() = testApplication {

        val response = client.get("/boruto/heroes?page=abcd")

        //assert returned status codes

        assertEquals(expected = HttpStatusCode.BadRequest, actual = response.status)

        val expected = ApiResponse(success = false,
                message = "Only Numbers Allowed")

        val actual =Json.decodeFromString<ApiResponse>(response.body())

        assertEquals(expected = expected, actual = actual)
    }


    @Test
    fun `access search heroes endpoint, query hero name, assert single hero result` () = testApplication {
        environment {
            developmentMode = false
        }
        val searchQuery = "sas"
        val response = client.get("/boruto/heroes/search?name=$searchQuery")

        //Assert status codes
        assertEquals(expected = HttpStatusCode.OK, actual = response.status)

        //expected search body
        val expected = repository.searchHeroes(searchQuery)
        val actual = Json.decodeFromString<ApiResponse>(response.body()).heroes.size

        //Assert API Response

        assertEquals(expected = 1, actual = actual)

    }



    @Test
    fun `access search heroes endpoint, query hero name, assert multiple heroes result` () =
        testApplication {
        environment {
            developmentMode = false
        }
        val searchQuery = "sa"
        val response = client.get("/boruto/heroes/search?name=$searchQuery")

        //Assert status codes
        assertEquals(expected = HttpStatusCode.OK, actual = response.status)

        //expected search body
        val expected = repository.searchHeroes(searchQuery)
        val actual = Json.decodeFromString<ApiResponse>(response.body()).heroes.size

        //Assert API Response

        assertEquals(expected = 3, actual = actual)

    }


    private fun calculatePageNumber(page: Int): Map<String, Int?> {

        var nextPage: Int? = page
        var prevPage: Int? = page

        if (page in 1..4) {

            nextPage = page.plus(1)
        }
        if (page in 2..5) {

            prevPage = page.minus(1)
        }

        //no room to decrease next page
        if (page == 1) {

            prevPage = null
        }

        //no room to increase next page
        if (page == 5) {
            nextPage = null
        }


        return mapOf(PREV_PAGE_KEY to prevPage, NEXT_PAGE_KEY to nextPage)

    }

}