package com.niluogege.debug.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig

class PagingRepository {
    fun getPagingDataSource() = Pager(PagingConfig(pageSize = 20)) {
        PagingDataSource()
    }.flow
}