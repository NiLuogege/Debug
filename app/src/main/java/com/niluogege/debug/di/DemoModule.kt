package com.niluogege.debug.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class DemoModule {

    var application: Application

    constructor(application: Application) {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    fun provideSpeak(str:String):Speaker{
        return Speaker(str)
    }

    @Singleton
    @Named("Car1")
    @Provides
    fun provideCar(): Car {
        println("provideCar")
        return Car(provideSpeak("wo shi car1"))
    }

    @Named("Car2")
    @Provides
    fun provideCar2(): Car {
        println("provideCar2")
        return Car(provideSpeak("wo shi car2"))
    }
}