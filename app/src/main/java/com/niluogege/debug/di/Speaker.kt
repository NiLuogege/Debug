package com.niluogege.debug.di

import javax.inject.Inject

class Speaker @Inject constructor(var str:String) {

    fun speak(){
        println("speak -->${str}")
    }

}