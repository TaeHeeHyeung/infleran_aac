package com.project.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.switchMap

class MyViewModel(
//    _counter: Int,
    private val repositoryImpl: RepositoryImpl,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    //    var counter: Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: repository.getCount()
    val counterFromRepository : LiveData<Int> = repositoryImpl.getCounter()


    var hasChecked: MutableLiveData<Boolean> = MutableLiveData<Boolean>(false)


    //    val modifiedCounter: LiveData<String> = Transformations.map(liveCounter){
//        counter ->"$counter 입니다."
//    }
    // 동일한 LiveData 리턴 (동일한 liveData에 value를 넣어서 리턴하는 방식임)
    val modifiedCounter: LiveData<String> = repositoryImpl.getCounter().map { it ->
        "$it 입니다."
    }

    // 새로운 LiveData 리턴 (새로운 liveData에 value를 넣어서 리턴하는 방식임)
    val modifiedCounter_test: LiveData<String> = repositoryImpl.getCounter().switchMap { counter ->
        MutableLiveData<String>().apply {
            value = "$counter 입니다."
        }
    }


    fun saveState() {
        savedStateHandle[SAVE_STATE_KEY] = repositoryImpl.getCounter()
    }

    fun increase() {
        repositoryImpl.increaseCount()
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}