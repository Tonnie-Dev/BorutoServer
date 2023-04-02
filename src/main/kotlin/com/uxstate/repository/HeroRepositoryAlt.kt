package com.uxstate.repository

import com.uxstate.model.ApiResponse
import com.uxstate.model.Hero

interface HeroRepositoryAlt {

val heroes:List<Hero>
    suspend fun getAllHeroes(page:Int = 1, limit:Int = 4    )
    suspend fun searchHeroes(name:String?):ApiResponse
}