package com.example.mvvm_recyclerview_firebase_example.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_recyclerview_firebase_example.User
import com.google.firebase.firestore.FirebaseFirestore


class Repository {

    fun getUserData() : LiveData<MutableList<User>>{
        val mutableData = MutableLiveData<MutableList<User>>()
        val listData = mutableListOf<User>()
        val db = FirebaseFirestore.getInstance()
        FirebaseFirestore.getInstance().collection("users").get().addOnSuccessListener { result ->
        for (document in result){
            var imageUrl    = document.getString("imageUrl")
            var name        = document.getString("name")
            var description = document.getString("description")

            val user = User(imageUrl!!, name!!, description!!)
            listData.add(user)
        }
            mutableData.value = listData
    }
        return mutableData
    }
}