package com.ninis.hilt_sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninis.hilt_sample.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val service: ApiService): ViewModel() {

    val userInfoTxt = MutableLiveData("")

    fun getUser() {
        viewModelScope.launch {
            val user = service.getData()

            userInfoTxt.value = "ID : ${user.id}\nTitle : ${user.title}\nBody : ${user.body}"
        }
    }
}