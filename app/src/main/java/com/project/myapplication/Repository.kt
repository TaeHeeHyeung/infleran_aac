package com.project.myapplication

import androidx.lifecycle.LiveData

interface Repository {

    fun getCounter(): LiveData<Int>

    fun increaseCount()
}