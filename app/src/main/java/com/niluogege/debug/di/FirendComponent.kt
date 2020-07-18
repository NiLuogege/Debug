package com.niluogege.debug.di

import dagger.Component

@FriendScope
@Component(dependencies = [ManComponent::class])
interface FirendComponent {
    fun inject(friend: Friend)
}