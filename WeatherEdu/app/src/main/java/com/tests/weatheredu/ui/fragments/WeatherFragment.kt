package com.tests.weatheredu.ui.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.tests.weatheredu.R
import com.tests.weatheredu.data.local_db.RoomAppDb
import com.tests.weatheredu.data.local_db.UserEntity
import com.tests.weatheredu.data.repositories.Repository
import com.tests.weatheredu.databinding.FragmentWeatherBinding
import com.tests.weatheredu.ui.fragments.HomeFragment.Companion.cityName
//import com.tests.weatheredu.ui.fragments.HomeFragment.Companion.cityTemp
import com.tests.weatheredu.ui.viewmodel.MainViewModel
import com.tests.weatheredu.ui.viewmodel.MainViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WeatherFragment : Fragment(R.layout.fragment_weather) {


    @Inject
    lateinit var msg: String

    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentWeatherBinding


  /*  companion object{
        var cityTemp = ""
    }*/



    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val msg = getString(R.string.msg)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        mainViewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val DAO = RoomAppDb.getAppDatabase(requireContext())!!.userDao()

        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)
        val tvTemperature = view.findViewById<TextView>(R.id.tvTemperature)
        val tvWind = view.findViewById<TextView>(R.id.tvWind)
        val tvForecast1 = view.findViewById<TextView>(R.id.tvForecast1)
        val tvForecast2 = view.findViewById<TextView>(R.id.tvForecast2)
        val tvForecast3 = view.findViewById<TextView>(R.id.tvForecast3)
        //val cityTemp = ""


        val goToFavFragButton = view.findViewById<Button>(R.id.button_frag_fave)
        val favBtn = view.findViewById<Button>(R.id.favBtn)
        goToFavFragButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_weatherFragment_to_favouritesFragment)

        }

        favBtn.setOnClickListener {

            val obj = UserEntity(0, cityName/*, cityTemp*/)
            DAO!!.insertUser(obj)
            favBtn.visibility= View.INVISIBLE
        }

        val goToActivities = view.findViewById<Button>(R.id.button_frag_act)
        goToActivities.setOnClickListener{
            it.findNavController().navigate(R.id.action_weatherFragment_to_weatherActivitesFragment)
        }


        mainViewModel.getWeather(cityName)
        mainViewModel.weatherResponse.observe(requireActivity()) {
            if (it.isSuccessful) {
                tvDescription.text = it.body()!!.description
                tvTemperature.text = it.body()!!.temperature
                //cityTemp = it.body()!!.temperature
                tvWind.text = it.body()!!.wind

                val forecast = it.body()!!.forecast
                tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
                tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
                tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"



            } else {
                Toast.makeText(context, "${it.message()}", Toast.LENGTH_SHORT).show()
                Toast.makeText(context, "${msg}", Toast.LENGTH_LONG).show()



            }
        }
    }


}