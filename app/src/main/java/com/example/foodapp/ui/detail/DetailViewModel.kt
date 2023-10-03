package com.example.foodapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.domain.RecipeCardModel
import com.example.foodapp.util.Constant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(): ViewModel() {
    private val _stateDetail = MutableStateFlow<RecipeCardModel>(Constant.dessertList[0])
    val stateDetail: StateFlow<RecipeCardModel> = _stateDetail
    fun loadState(recipeCardModel: RecipeCardModel) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateDetail.emit(recipeCardModel)
        }
    }
}