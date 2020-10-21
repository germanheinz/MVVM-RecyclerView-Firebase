package com.example.mvvm_recyclerview_firebase_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_recyclerview_firebase_example.domain.data.network.Repository


// TODO - VIEWMODEL - 1 - CREATE A CLASS THAT EXTENDS VIEWMODEL
class MainViewModel : ViewModel() {

    // TODO - VIEWMODEL - 2 - CREATE A FUNCTION TO GET DATA FROM DB AND RETURN MUTABLELIVEDATA VARIABLE
    // GET REPOSITORY
    private val repositpry = Repository()

    fun fetchUserData() : LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        repositpry.getUserData().observeForever { users ->
            mutableData.value = users
        }
        return mutableData
    }

}