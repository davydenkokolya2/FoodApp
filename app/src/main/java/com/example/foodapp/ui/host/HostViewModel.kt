package com.example.foodapp.ui.host

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.util.Host
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HostViewModel @Inject constructor() : ViewModel() {
    private val _stateHost = MutableStateFlow<Host>(Host.HOME)
    val stateHost: StateFlow<Host> = _stateHost
    fun loadState(host: Host) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateHost.emit(host)
        }
    }

}