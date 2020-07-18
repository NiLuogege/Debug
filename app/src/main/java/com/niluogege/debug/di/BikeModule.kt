package com.niluogege.debug.di

import dagger.Module
import dagger.Provides

@Module
class BikeModule {

    @Provides
    fun privideBike():Bike{
        return Bike()
    }
}