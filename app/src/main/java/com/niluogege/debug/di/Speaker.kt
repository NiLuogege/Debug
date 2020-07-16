package com.niluogege.debug.di

import javax.inject.Inject

class Speaker @Inject constructor() {

    fun speak(){
        println("speak")
    }

}