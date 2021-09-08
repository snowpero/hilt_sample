package com.ninis.hilt_sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ninis.hilt_sample.network.ApiService
import com.ninis.hilt_sample.network.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel() {

    val userInfoTxt = MutableLiveData("")

    fun getUser() {
        viewModelScope.launch {
            val user = repository.getUser()

            userInfoTxt.value = "ID : ${user.id}\nTitle : ${user.title}\nBody : ${user.body}"
        }
    }
}