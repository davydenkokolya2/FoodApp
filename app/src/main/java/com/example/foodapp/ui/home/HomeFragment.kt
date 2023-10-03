package com.example.foodapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.domain.RecipeCardModel
import com.example.foodapp.ui.detail.DetailViewModel
import com.example.foodapp.ui.host.HostViewModel
import com.example.foodapp.util.Constant
import com.example.foodapp.util.Home
import com.example.foodapp.util.Host
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by activityViewModels()
    private val detailViewModel: DetailViewModel by activityViewModels()
    private val hostViewModel: HostViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvHome.layoutManager = layoutManager
        lifecycleScope.launch {
            homeViewModel.stateHome.collect {
                binding.tvAll.setTextColor(resources.getColor(R.color.grey))
                binding.tvSoups.setTextColor(resources.getColor(R.color.grey))
                binding.tvSalads.setTextColor(resources.getColor(R.color.grey))
                binding.tvDesserts.setTextColor(resources.getColor(R.color.grey))
                binding.tvDrink.setTextColor(resources.getColor(R.color.grey))
                when (it) {
                    Home.ALL -> {
                        binding.tvAll.setTextColor(resources.getColor(R.color.green))
                        setAdapter(Home.ALL)
                    }

                    Home.DRINKS -> {
                        binding.tvDrink.setTextColor(resources.getColor(R.color.green))
                        setAdapter(Home.DRINKS)
                    }

                    Home.SALADS -> {
                        binding.tvSalads.setTextColor(resources.getColor(R.color.green))
                        setAdapter(Home.SALADS)
                    }

                    Home.DESSERTS -> {
                        binding.tvDesserts.setTextColor(resources.getColor(R.color.green))
                        setAdapter(Home.DESSERTS)

                    }

                    Home.SOUPS -> {
                        binding.tvSoups.setTextColor(resources.getColor(R.color.green))
                        setAdapter(Home.SOUPS)
                    }
                }
            }
        }
        binding.tvAll.setOnClickListener {
            homeViewModel.loadState(Home.ALL)
        }
        binding.tvDrink.setOnClickListener {
            homeViewModel.loadState(Home.DRINKS)
        }
        binding.tvDesserts.setOnClickListener {
            homeViewModel.loadState(Home.DESSERTS)
        }
        binding.tvSalads.setOnClickListener {
            homeViewModel.loadState(Home.SALADS)
        }
        binding.tvSoups.setOnClickListener {
            homeViewModel.loadState(Home.SOUPS)
        }

        return binding.root
    }

    private fun setAdapter(home: Home) {
        when (home) {
            Home.ALL -> binding.rvHome.adapter = HomeViewAdapter(Constant.soupList + Constant.drinkList + Constant.dessertList + Constant.saladList, ::onClick, ::onClickCard)
            Home.DESSERTS -> binding.rvHome.adapter = HomeViewAdapter(Constant.dessertList, ::onClick, ::onClickCard)
            Home.DRINKS -> binding.rvHome.adapter = HomeViewAdapter(Constant.drinkList, ::onClick, ::onClickCard)
            Home.SOUPS -> binding.rvHome.adapter = HomeViewAdapter(Constant.soupList, ::onClick, ::onClickCard)
            Home.SALADS -> binding.rvHome.adapter = HomeViewAdapter(Constant.saladList, ::onClick, ::onClickCard)
        }
    }

    private fun onClick(position: Int, list: List<RecipeCardModel>) {
        val buffer = homeViewModel.stateHome.value.also {
            setAdapter(it)
        }
        if (!Constant.favouriteList.remove(list[position]))
            Constant.favouriteList.add(list[position])
    }
    private fun onClickCard(recipeCardModel: RecipeCardModel) {
        detailViewModel.loadState(recipeCardModel)
        hostViewModel.loadState(Host.DETAIL)
    }
}