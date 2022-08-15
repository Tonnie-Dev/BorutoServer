package com.uxstate.repository

import com.uxstate.model.Hero

interface HeroRepository {

    //map page no to a list of heroes
    val heroes:Map<Int,List<Hero>>

    //individual pages reference
    val page1:List<Hero>
}