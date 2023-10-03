package com.example.foodapp.ui.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.databinding.FragmentFavouritesBinding
import com.example.foodapp.domain.RecipeCardModel
import com.example.foodapp.ui.detail.DetailViewModel
import com.example.foodapp.ui.home.HomeViewAdapter
import com.example.foodapp.ui.host.HostViewModel
import com.example.foodapp.util.Constant
import com.example.foodapp.util.Host

class FavouritesFragment : Fragment() {

    private lateinit var binding: FragmentFavouritesBinding
    private val detailViewModel: DetailViewModel by activityViewModels()
    private val hostViewModel: HostViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouritesBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireActivity(), 2)
        binding.rvFavourite.layoutManager = layoutManager
        setAdapter()
        return binding.root
    }
    private fun setAdapter() {
        binding.rvFavourite.adapter = HomeViewAdapter(Constant.favouriteList, ::onClick, ::onClickCard)
    }
    private fun onClick(position: Int, list: List<RecipeCardModel>) {
        if (!Constant.favouriteList.remove(list[position]))
            Constant.favouriteList.add(list[position])
        setAdapter()
    }

    private fun onClickCard(recipeCardModel: RecipeCardModel) {
        detailViewModel.loadState(recipeCardModel)
        hostViewModel.loadState(Host.DETAIL)
    }
}