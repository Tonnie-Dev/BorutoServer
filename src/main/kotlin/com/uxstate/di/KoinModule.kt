package com.uxstate.di

import com.uxstate.repository.HeroRepository
import com.uxstate.repository.HeroRepositoryAlt
import com.uxstate.repository.HeroRepositoryImpl
import com.uxstate.repository.HeroRepositoryImplAlt
import org.koin.dsl.module

//module{} (from koin) specifies how to inject certain types e.g. repository
val koinModule = module {

  /*  defines how to specify a kind inside here using singleton for
    single instance - across the Boruto server*/

    single<HeroRepository> {

        //specify the implementation
        HeroRepositoryImpl()
    }

    /*
    single -implies this is a singleton
    HeroRepositoryAlt - this is the type
    HeroRepositoryImplAlt - is the implementation
    */
    single <HeroRepositoryAlt>{

        HeroRepositoryImplAlt()
    }

}