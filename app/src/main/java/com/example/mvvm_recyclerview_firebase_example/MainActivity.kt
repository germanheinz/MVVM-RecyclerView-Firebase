package com.example.mvvm_recyclerview_firebase_example

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // TODO 6 - DECLARE ADAPTER
    private lateinit var adapter: MainAdapter

    //LAZY SAY,  I'M GOING TO INITIALIZE YOU WHEN I NEED IT
    private val viewModel by lazy {ViewModelProviders.of(this).get(MainViewModel::class.java)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO 1 - DECLARE RECYCLERVIEW, AND GIVE IT ORIENTATION, BY DEFAULT IS VERTICAL
        recyclerView.layoutManager = LinearLayoutManager(this)

        //TODO 2 - CREATE ADAPTER - RECEIVE AN ARRAY AND ITERATE EACH ITEM TO PUT IT ON IN THE RECYCLERVIEW, INSTANCE
        adapter = MainAdapter(this)

        recyclerView.adapter = adapter

        observeData()



    }

    fun observeData(){
        //Adding Shimmer
        shimmer_view_container.startShimmer()
        viewModel.fetchUserData().observe(this, Observer {
            shimmer_view_container.stopShimmer()
            shimmer_view_container.visibility = View.GONE
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }
}
