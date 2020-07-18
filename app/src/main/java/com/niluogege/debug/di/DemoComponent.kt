package com.niluogege.debug.di

import com.niluogege.debug.App
import com.niluogege.debug.dagger.DaggerActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DemoModule::class])
interface DemoComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app:App):Builder
        fun build():DemoComponent
    }

    //注入 DaggerActivity 需要的依赖
    fun inject(daggerActivity: DaggerActivity)
}