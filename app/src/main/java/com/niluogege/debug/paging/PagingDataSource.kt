package com.niluogege.debug.paging

import androidx.paging.PagingSource

class PagingDataSource : PagingSource<Int, PagingItem>() {

    /**
     * 实现这个方法来触发异步加载(例如从数据库或网络)。 这是一个suspend挂起函数，可以很方便的使用协程异步加载
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PagingItem> {
        return try {

            println("params.key= ${params.key}")

            val page = params.key ?: 0
            val result = DataMaker.getDataList(page*20)
            LoadResult.Page(
                    data = result,
                    prevKey = null,
                    nextKey = page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}