package com.example.testing.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var point = MutableLiveData<Int>(0)

    fun getPoint():LiveData<Int>{
        return point
    }
    fun add(number:Int) {
        point.value = point.value!! + number
    }
    fun clear(){
        point.value = 0
    }
}