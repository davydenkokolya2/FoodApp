package com.example.foodapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.util.Home
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _stateHome = MutableStateFlow<Home>(Home.ALL)
    val stateHome: StateFlow<Home> = _stateHome
    fun loadState(home: Home) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHome.emit(home)
        }
    }
}