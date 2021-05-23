package com.jorbital.jorbichef.data

import com.jorbital.jorbichef.models.Ingredient
import com.jorbital.jorbichef.models.IngredientType

val ingredients = mutableListOf(
    Ingredient(id = "1", name = "Salt", type = IngredientType.SPICE),
    Ingredient(id = "2", name = "Pepper", type = IngredientType.SPICE),
    Ingredient(id = "3", name = "Parsley", type = IngredientType.HERB),
    Ingredient(id = "4", name = "Ribeye", type = IngredientType.PROTEIN),
    Ingredient(id = "5", name = "Chicken breast", type = IngredientType.PROTEIN),
    Ingredient(id = "6", name = "Carrot", type = IngredientType.VEGETABLE),
    Ingredient(id = "7", name = "Lettuce", type = IngredientType.VEGETABLE),
    Ingredient(id = "8", name = "Brussel sprouts", type = IngredientType.VEGETABLE),
    Ingredient(id = "9", name = "Mango", type = IngredientType.FRUIT)
)