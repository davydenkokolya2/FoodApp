package com.example.foodapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.foodapp.R
import com.example.foodapp.ui.host.HostFragment
import com.example.foodapp.ui.onboarding.OnboardingFragment
import com.example.foodapp.util.Nav
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navViewModel: NavViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            navViewModel.stateNav.collect {
                when(it) {
                    Nav.ONBOARDING -> replaceFragment(OnboardingFragment())
                    Nav.HOST -> replaceFragment(HostFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}