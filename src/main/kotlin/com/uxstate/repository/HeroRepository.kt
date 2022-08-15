package com.uxstate.repository

import com.uxstate.model.ApiResponse
import com.uxstate.model.Hero

interface HeroRepository {

    //map page no to a list of heroes
    val heroes:Map<Int,List<Hero>>

    //individual pages reference
    val page1:List<Hero>
    val page2:List<Hero>
    val page3:List<Hero>
    val page4:List<Hero>
    val page5:List<Hero>

    //return All Heroes taking the pg no to return
    suspend fun getAllHeroes(page:Int = 1):ApiResponse

    //return search result taking a query parameter
    suspend fun searchHeroes(name:String):ApiResponse
}