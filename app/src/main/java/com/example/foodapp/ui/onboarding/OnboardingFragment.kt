package com.example.foodapp.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.foodapp.databinding.FragmentOnboardingBinding
import com.example.foodapp.ui.NavViewModel
import com.example.foodapp.util.Nav

class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    private val navViewModel: NavViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.imageView3.setOnClickListener { navViewModel.loadState(Nav.HOST) }
        return binding.root
    }

}