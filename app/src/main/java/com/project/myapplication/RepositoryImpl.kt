package com.project.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RepositoryImpl(count: Int) : Repository {
    // 이 부분은 실제로는 room이나 retrofit에서 받아오게 됨
    private var liveCounter: MutableLiveData<Int> = MutableLiveData(count)
    override fun getCounter(): LiveData<Int> {
        return liveCounter;
    }

    override fun increaseCount(): Unit {
        liveCounter.value = liveCounter.value?.plus(1)
    }
}