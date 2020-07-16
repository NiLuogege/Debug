package com.niluogege.debug.di

import javax.inject.Inject

class Car @Inject constructor(private var speaker: Speaker) {


    fun print() {
        println("我是car")
    }

    fun speak() {
        speaker.speak()
    }

}