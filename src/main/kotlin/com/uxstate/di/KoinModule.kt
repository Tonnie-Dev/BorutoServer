package com.uxstate.di

import com.uxstate.repository.HeroRepository
import com.uxstate.repository.HeroRepositoryImpl
import org.koin.dsl.module

//module{} (from koin) specifies how to inject certain types e.g. repository
val koinModule = module {

    //specify how to specify a kind inside here using singleton for single instance

    single<HeroRepository> {

        //specify the implementation
        HeroRepositoryImpl()
    }

}