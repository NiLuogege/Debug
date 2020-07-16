package com.niluogege.debug.di

import android.app.Application
import dagger.Component

@Component(modules = [DemoModule::class])
interface DemoComponent {

    fun inject(application: Application)
}