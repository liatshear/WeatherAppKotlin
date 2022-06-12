package com.tests.weatheredu.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.tests.weatheredu.R
import com.tests.weatheredu.data.local_db.RoomAppDb
import com.tests.weatheredu.data.models.Activities
import com.tests.weatheredu.data.models.Seasons
import com.tests.weatheredu.databinding.ActivityMainBinding
import com.tests.weatheredu.databinding.FragmentFavouritesBinding
import com.tests.weatheredu.databinding.FragmentActivitiesweatherBinding
import com.tests.weatheredu.ui.RecyclerActivityAdapter
import com.tests.weatheredu.ui.RecyclerAdapter
import com.tests.weatheredu.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherActivities : Fragment(R.layout.fragment_activitiesweather) {

    private var imag: String? = null
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: FragmentActivitiesweatherBinding
    private var layoutManager: RecyclerView.LayoutManager?= null
    private var adapter: RecyclerAdapter?= null

    fun onCreate(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentActivitiesweatherBinding.inflate(inflater, container, false)
        return binding.root
    }
    private lateinit var viewModel: ViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val DAO = RoomAppDb.getAppDatabase(requireContext())!!.userDao()


        val wind = getString(R.string.Wind)
        val snow = getString(R.string.Snow)
        val sunny = getString(R.string.Sunny)
        val cold = getString(R.string.Cold)
        val overcast = getString(R.string.Overcast)
        val breezy = getString(R.string.Breezy)
        val storm = getString(R.string.Storm)
        val hail = getString(R.string.Hail)
        val rain = getString(R.string.Rain)

        val windA = getString(R.string.WindA)
        val snowA = getString(R.string.SnowA)
        val sunnyA = getString(R.string.SunnyA)
        val coldA = getString(R.string.ColdA)
        val overcastA = getString(R.string.OvercastA)
        val breezyA = getString(R.string.BreezyA)
        val stormA = getString(R.string.StormA)
        val hailA = getString(R.string.HailA)
        val rainA = getString(R.string.RainA)


        val seasons = arrayListOf(
            Seasons("$wind"),
            Seasons("$snow"),
            Seasons("$cold"),
            Seasons("$rain"),
            Seasons("$sunny"),
            Seasons("$overcast"),
            Seasons("$breezy"),
            Seasons("$hail"),
            Seasons("$storm"),

            )
        val activities = arrayListOf(
            Activities("$windA"),
            Activities("$snowA"),
            Activities("$coldA"),
            Activities("$rainA"),
            Activities("$sunnyA"),
            Activities("$overcastA"),
            Activities("$breezyA"),
            Activities("$hailA"),
            Activities("$stormA")
        )

        //layoutManager = LinearLayoutManager(this)



        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.apply {
            adapter = RecyclerActivityAdapter(seasons, activities)

        }

        val goBack = view.findViewById<Button>(R.id.goBack)
        goBack.setOnClickListener{
            it.findNavController().navigate(R.id.action_weatherActivitiesFragmemt_to_weatherFragment)
        }
        val goFave = view.findViewById<Button>(R.id.button_frag)
        goFave.setOnClickListener{
            it.findNavController().navigate(R.id.action_weatherActivitiesFragment_to_homeFragment)
        }


    }
}

