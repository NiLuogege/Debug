package com.niluogege.debug.di

import com.niluogege.debug.dagger.DaggerActivity
import dagger.Component

@Component(modules = [DemoModule::class])
interface DemoComponent {

    fun inject(daggerActivity: DaggerActivity)
}