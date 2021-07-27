package com.alecbrando.recyclerview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var count = 11
    private val list = mutableListOf(1,2,3,4,5,6,7,8,9,10)
    private val dataList = MutableLiveData<MutableList<Int>>()

    val data get () = dataList
    init {
        populateList()
    }

    private fun populateList() {
        dataList.value = list
    }

    fun addNum(){
        list.add(count)
        dataList.value = list
        count += 1
    }
}