package com.uxstate.repository

import com.uxstate.model.ApiResponse

interface HeroRepositoryAlt {


    suspend fun getAllHeroes(page:Int = 1, limit:Int = 4    )
    suspend fun searchHeroes(name:String?):ApiResponse
}