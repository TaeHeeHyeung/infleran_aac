package com.project.myapplication

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import java.lang.Exception

//class MyViewModelFactory(private val counter:Int): ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
// if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
//            val myViewModel = MyViewModel(counter, handle)
//            return myViewModel as T;
//        }
//        throw Exception("viewModel class not found")
//    }
//
//}

class MyViewModelFactory(
    private val counter: Int,
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            val myViewModel = MyViewModel(counter, handle)
            return myViewModel as T;
        }
        throw Exception("viewModel class not found")
    }
}