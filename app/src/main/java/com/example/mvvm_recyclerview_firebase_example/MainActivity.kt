package com.example.mvvm_recyclerview_firebase_example

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO 6 - DECLARE ADAPTER
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 1 - DECLARE RECYCLERVIEW, AND GIVE IT ORIENTATION, BY DEFAULT IS VERTICAL
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //TODO 2 - CREATE ADAPTER - RECEIVE AN ARRAY AND ITERATE EACH ITEM TO PUT IT ON IN THE RECYCLERVIEW
        recyclerView.adapter = MainAdapter(this)

        val userList = mutableListOf<User>()
        userList.add(User("https://www.w3schools.com/howto/img_avatar.png","User","testing MVVM - recycler view"))

        adapter.setListData(userList)
        adapter.notifyDataSetChanged()

    }
}
