package com.niluogege.debug.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DemoModule {

    var application: Application

    constructor(application: Application) {
        this.application = application
    }

    @Provides
    @Singleton
    fun provideApplication():Application{
        return application
    }


    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }
}