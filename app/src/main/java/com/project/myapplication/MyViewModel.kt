package com.project.myapplication

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(
    counter_: Int,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    var counter: Int = savedStateHandle.get<Int>(SAVE_STATE_KEY) ?: counter_

    fun saveState() {
        savedStateHandle[SAVE_STATE_KEY] = counter
    }

    companion object {
        private const val SAVE_STATE_KEY = "counter"
    }
}