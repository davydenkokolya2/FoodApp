package com.example.foodapp.util

import com.example.foodapp.R
import com.example.foodapp.domain.RecipeCardModel

object Constant {
    val dessertList = mutableListOf(
        RecipeCardModel(
            R.drawable.p_o_jpg,
            15,
            R.string.chokladbollar,
            R.string.dessert,
            R.drawable.icon_favourites_false,
            2,
            mutableListOf(
                R.string.ingredient_1,
                R.string.ingredient_2,
                R.string.ingredient_3,
                R.string.ingredient_4,
            ),
            mutableListOf(
                R.string.recipe_1,
                R.string.recipe_2,
                R.string.recipe_3,
            ),
        )
    )
    val soupList = mutableListOf(
        RecipeCardModel(
            R.drawable.ob_05_1568611223_1280x640,
            60,
            R.string.borsch,
            R.string.soup,
            R.drawable.icon_favourites_false,
            4,
            mutableListOf(
                R.string.ingredient_1,
                R.string.ingredient_2,
                R.string.ingredient_3,
                R.string.ingredient_4,
            ),
            mutableListOf(
                R.string.recipe_1,
                R.string.recipe_2,
                R.string.recipe_3,
            ),
        )
    )
    val saladList = mutableListOf(
        RecipeCardModel(
            R.drawable.arugula_salad_1,
            30,
            R.string.italian_chopped_salad,
            R.string.salad,
            R.drawable.icon_favourites_false,
            5,
            mutableListOf(
                R.string.ingredient_1,
                R.string.ingredient_2,
                R.string.ingredient_3,
                R.string.ingredient_4,
            ),
            mutableListOf(
                R.string.recipe_1,
                R.string.recipe_2,
                R.string.recipe_3,
            ),
        )
    )
    val drinkList = mutableListOf(
        RecipeCardModel(
            R.drawable.whiskey_sour_111,
            10,
            R.string.whiskey_sour,
            R.string.drink,
            R.drawable.icon_favourites_false,
            3,
            mutableListOf(
                R.string.ingredient_1,
                R.string.ingredient_2,
                R.string.ingredient_3,
                R.string.ingredient_4,
            ),
            mutableListOf(
                R.string.recipe_1,
                R.string.recipe_2,
                R.string.recipe_3,
            ),
        )
    )
    val favouriteList = mutableListOf<RecipeCardModel>()
}