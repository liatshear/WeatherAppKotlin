package com.tests.weatheredu.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.tests.weatheredu.R
import com.tests.weatheredu.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var viewModel: ViewModel
    private lateinit var binding: FragmentHomeBinding


    companion object{
        var cityName=""
        //var cityTemp=""
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val input = view.findViewById<EditText>(R.id.enter_city)

        val button_weather = view.findViewById<Button>(R.id.button_weather)


        button_weather.setOnClickListener {
            if(input.text.isNotEmpty()){
                cityName=input.text.toString()
                it.findNavController().navigate(R.id.action_homeFragment_to_weatherFragment)
            }else{
                input.error = "You need to enter an input city"
            }
        }
        val goToFavFragButton = view.findViewById<Button>(R.id.button_frag_fave)
        goToFavFragButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_favouritesFragment)
        }

    }


}