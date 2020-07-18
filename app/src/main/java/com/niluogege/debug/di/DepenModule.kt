package com.niluogege.debug.di

import dagger.Module
import dagger.Provides

@Module
class DepenModule {


    @Provides
    fun privideCar():Car{
        return Car(Speaker("b j c q "))
    }
}