package com.niluogege.debug.paging

object DataMaker {


    fun getDataList(start: Int): ArrayList<PagingItem> {
        val list = ArrayList<PagingItem>()
        for (i in start..(start + 20)) {
            val item = PagingItem()
            item.name = "name$i"
            item.age = "age$i"
            list.add(item)
        }
        return list
    }

}