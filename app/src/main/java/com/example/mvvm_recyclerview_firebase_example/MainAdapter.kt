package com.example.mvvm_recyclerview_firebase_example

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<User>()

    fun setListData(data : MutableList<User>){
        dataList = data
    }

    //TODO 4 - OVERRIDE THE 3 METHODS OF THE ADAPTER CLASS
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        //TODO 5 - INFLATE THE ITEM VIEW AND RETURN IT
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(dataList.size > 0){
            return dataList.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
    }

    // TODO 3 - CREATE A HOLDER CLASS. AND GIVE IT THE ITEMS
    inner class MainViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        //TODO 4 - BIND VALUES IN THE ITEM VIEW
        fun bindView(user: User){
            Glide.with(context).load(user.imageUrl).into(itemView.circleImageView)
            itemView.text_title.text       = user.name
            itemView.text_description.text = user.description
        }
    }


}

//viewholder inicializa la vista

// onCreateViewHolder -
// ViewType: this is when we'v got different itemCard to show
// Parent: Container