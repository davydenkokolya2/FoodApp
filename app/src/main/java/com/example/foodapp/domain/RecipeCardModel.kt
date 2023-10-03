package com.example.foodapp.domain

data class RecipeCardModel(
    val image: Int,
    val time: Int,
    val title: Int,
    val group: Int,
    var favourite: Int,
    var star: Int,
    var ingredients: MutableList<Int>,
    var recipe: MutableList<Int>,
)
