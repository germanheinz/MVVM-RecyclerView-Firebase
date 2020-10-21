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
        recyclerView.layoutManager = LinearLayoutManager(this)

        //TODO 2 - CREATE ADAPTER - RECEIVE AN ARRAY AND ITERATE EACH ITEM TO PUT IT ON IN THE RECYCLERVIEW, INSTANCE
        adapter = MainAdapter(this)

        recyclerView.adapter = adapter

        val userList = mutableListOf<User>()
        userList.add(User("https://static.wikia.nocookie.net/chespirito/images/9/93/El-chavo-del-8.jpg/revision/latest/top-crop/width/360/height/450?cb=20140212023312&path-prefix=es","User","testing MVVM - recycler view"))
        userList.add(User("https://www.w3schools.com/howto/img_avatar.png","User","testing MVVM - recycler view"))
        userList.add(User("https://www.w3schools.com/howto/img_avatar.png","User","testing MVVM - recycler view"))
        userList.add(User("https://www.w3schools.com/howto/img_avatar.png","User","testing MVVM - recycler view"))

        adapter.setListData(userList)
        adapter.notifyDataSetChanged()

    }
}
