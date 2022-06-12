package com.tests.weatheredu.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tests.weatheredu.R
import com.tests.weatheredu.data.local_db.RoomAppDb
import com.tests.weatheredu.data.local_db.UserEntity
import com.tests.weatheredu.databinding.FragmentFavouritesBinding
import com.tests.weatheredu.ui.RecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.properties.Delegates

@AndroidEntryPoint
class FavouritesFragment : Fragment(R.layout.fragment_favourites) {


    private lateinit var binding: FragmentFavouritesBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        return binding.root
    }


    private lateinit var viewModel: ViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dao = RoomAppDb.getAppDatabase(requireContext())!!.userDao()


        val list = ArrayList<UserEntity>()

        var found =  false

        if (dao!!.getAllUserInfo()!!.isNotEmpty()) {
            for (i in 0 until dao.getAllUserInfo()!!.size) {
                dao.getAllUserInfo()?.get(i)?.let {
                    for (city in list) {
                        if (city.city == it.city) {
                            found = true
                        }
                    }
                    if (!found) {
                        list.add(
                            UserEntity(i, it.city /*, it.temp*/)
                        )
                    }
                }
            }
        }
        else {
            Toast.makeText(context, "you have not added any favourites yet", Toast.LENGTH_SHORT).show()
        }


        if (!list.isEmpty()) {
            binding.rcv.layoutManager = LinearLayoutManager(requireContext())
            binding.rcv.adapter = RecyclerAdapter(requireContext(), list)
        }

        val goToHome = view.findViewById<Button>(R.id.button_frag_fave)
        //val favBtn = view.findViewById<Button>(R.id.favBtn)
        goToHome.setOnClickListener {
            it.findNavController().navigate(R.id.action_favouritesFragment_to_homeFragment)
        }


    }
}