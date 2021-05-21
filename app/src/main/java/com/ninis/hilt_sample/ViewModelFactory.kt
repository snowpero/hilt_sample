package com.ninis.hilt_sample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ninis.hilt_sample.network.ApiService
import java.lang.IllegalArgumentException

class ViewModelFactory(private val service: ApiService) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if( modelClass.isAssignableFrom(MainViewModel::class.java)) {
            MainViewModel(service) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}