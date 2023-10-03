package com.example.foodapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentDetailBinding
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireActivity(), 1)
        val layoutManager2 = GridLayoutManager(requireActivity(), 1)
        binding.rvRecipe.layoutManager = layoutManager
        binding.rvIngredient.layoutManager = layoutManager2
        lifecycleScope.launch {
            detailViewModel.stateDetail.collect {
                binding.rvRecipe.adapter = RecipeViewAdapter(it.recipe)
                binding.rvIngredient.adapter = IngredientViewAdapter(it.ingredients)
                binding.tvDetailTime.text = "${it.time} Min"
                binding.tvDetailGroup.setText(it.group)
                binding.tvDetailTitle.setText(it.title)
                binding.ivDetail.setImageResource(it.image)
                if (it.star >= 1)
                    binding.ivStar1.setImageResource(R.drawable.icon_star_true)
                if (it.star >= 2)
                    binding.ivStar2.setImageResource(R.drawable.icon_star_true)
                if (it.star >= 3)
                    binding.ivStar3.setImageResource(R.drawable.icon_star_true)
                if (it.star >= 4)
                    binding.ivStar4.setImageResource(R.drawable.icon_star_true)
                if (it.star >= 5)
                    binding.ivStar5.setImageResource(R.drawable.icon_star_true)
            }
        }
        return binding.root
    }

}