package com.niluogege.debug.di

import javax.inject.Inject

class Car @Inject constructor() {

    fun print(){
        println("我是car")
    }

}