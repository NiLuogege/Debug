package com.niluogege.debug.di

import javax.inject.Inject

class Friend {
    @Inject
    lateinit var car: Car

    fun go(){
        car.speak()
    }
}