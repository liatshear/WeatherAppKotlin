package com.tests.weatheredu.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.tests.weatheredu.R
import com.tests.weatheredu.data.local_db.UserEntity
import com.tests.weatheredu.ui.fragments.HomeFragment

class RecyclerAdapter(val context: Context, var list: MutableList<UserEntity>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_for_favourites, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txt.text=list[position].city
       // holder.temp.text=list[position].temp
        holder.txt.setOnClickListener {
            HomeFragment.cityName =list[position].city
            it.findNavController().navigate(R.id.action_favouritesFragment_to_weatherFragment2)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var txt = itemView.findViewById<TextView>(R.id.tv_item)
        //var temp = itemView.findViewById<TextView>(R.id.tv_temp)



    }
}