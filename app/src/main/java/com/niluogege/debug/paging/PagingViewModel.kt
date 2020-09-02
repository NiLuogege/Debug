package com.niluogege.debug.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class PagingViewModel : ViewModel() {
    private val repository:PagingRepository by lazy { PagingRepository() }

    fun getPagingData()=repository.getPagingDataSource().asLiveData()
}