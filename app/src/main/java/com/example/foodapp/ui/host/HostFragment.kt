package com.example.foodapp.ui.host

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHostBinding
import com.example.foodapp.ui.detail.DetailFragment
import com.example.foodapp.ui.favourites.FavouritesFragment
import com.example.foodapp.ui.home.HomeFragment
import com.example.foodapp.util.Host
import kotlinx.coroutines.launch

class HostFragment : Fragment() {

    private lateinit var binding: FragmentHostBinding
    private val hostViewModel: HostViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHostBinding.inflate(inflater, container, false)

        lifecycleScope.launch {
            hostViewModel.stateHost.collect {
                binding.btnBack.visibility = View.INVISIBLE
                binding.btnHome.setImageResource(R.drawable.icon_home_false)
                binding.btnDetail.setImageResource(R.drawable.icon_detail_false)
                binding.btnFavourites.setImageResource(R.drawable.icon_favourites_false)
                    when(it) {
                    Host.HOME -> {
                        replaceFragment(HomeFragment())
                        binding.btnHome.setImageResource(R.drawable.icon_home_true)
                        binding.tvHostTitle.setText(R.string.home)
                    }
                    Host.DETAIL -> {
                        replaceFragment(DetailFragment())
                        binding.btnBack.visibility = View.VISIBLE
                        binding.btnDetail.setImageResource(R.drawable.icon_detail_true)
                        binding.tvHostTitle.setText(R.string.detail)
                    }
                    Host.FAVOURITE -> {
                        replaceFragment(FavouritesFragment())
                        binding.btnBack.visibility = View.VISIBLE
                        binding.btnFavourites.setImageResource(R.drawable.icon_favourites_true)
                        binding.tvHostTitle.setText(R.string.favourites)
                    }
                }
            }
        }
        binding.btnHome.setOnClickListener {
            hostViewModel.loadState(Host.HOME)
        }
        binding.btnFavourites.setOnClickListener {
            hostViewModel.loadState(Host.FAVOURITE)
        }
        binding.btnDetail.setOnClickListener {
            hostViewModel.loadState(Host.DETAIL)
        }
        binding.btnBack.setOnClickListener {
            hostViewModel.loadState(Host.HOME)
        }
        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView2, fragment)
        fragmentTransaction.commit()
    }
}