package com.niluogege.debug.di

import com.niluogege.debug.dagger.DaggerActivity
import dagger.Component

@Component(modules = [DemoModule::class])
interface DemoComponent {

    //注入 DaggerActivity 需要的依赖
    fun inject(daggerActivity: DaggerActivity)
}