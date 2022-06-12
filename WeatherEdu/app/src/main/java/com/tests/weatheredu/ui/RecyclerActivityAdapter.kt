package com.tests.weatheredu.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tests.weatheredu.R
import com.tests.weatheredu.data.models.Activities
import com.tests.weatheredu.data.models.Seasons

class RecyclerActivityAdapter(private val weathertypes: ArrayList<Seasons>, private val activitytypes: ArrayList<Activities>):
    RecyclerView.Adapter<RecyclerActivityAdapter.UserViewHolder>() {

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val weatherType : TextView = view.findViewById(R.id.weatherType)
        val activityType : TextView = view.findViewById(R.id.activityType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_activities_layout, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.weatherType.text = weathertypes[position].weather_type
        holder.activityType.text = activitytypes[position].activity_type
    }

    override fun getItemCount(): Int = weathertypes.size



}