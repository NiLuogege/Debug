package com.niluogege.debug.di

import javax.inject.Inject

class Bike @Inject constructor(){


    fun go(){
        print("go go go")
    }
}