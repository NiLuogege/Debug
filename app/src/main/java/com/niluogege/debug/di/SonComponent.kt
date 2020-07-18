package com.niluogege.debug.di

import dagger.Component
import dagger.Subcomponent

@SonScope
@Subcomponent(modules = [BikeModule::class])
interface SonComponent {

    fun  inject(son: Son)


    @Subcomponent.Builder
    interface Builder{
         fun build():SonComponent
    }
}