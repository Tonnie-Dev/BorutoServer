package com.uxstate.repository

import com.uxstate.model.ApiResponse

class HeroRepositoryImplAlt: HeroRepositoryAlt{
    override suspend fun getAllHeroes(page: Int, limit: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun searchHeroes(name: String?): ApiResponse {
        TODO("Not yet implemented")
    }
}