package com.niluogege.debug.di

import dagger.Component

@MyScope
@Component(modules = [DependModule::class])
interface ManComponent {

    fun inject(man: Man)

    fun getCar():Car

}