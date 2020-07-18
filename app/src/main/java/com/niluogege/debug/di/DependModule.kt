package com.niluogege.debug.di

import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class DependModule {

    @Provides
    fun privideCar():Car
    {
        return Car(Speaker("我是 要被借出去 的car"))
    }
}