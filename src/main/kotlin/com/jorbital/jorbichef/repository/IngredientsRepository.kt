package com.jorbital.jorbichef.repository

import com.jorbital.jorbichef.models.Ingredient
import com.jorbital.jorbichef.models.IngredientInput
import com.jorbital.jorbichef.models.IngredientType

interface IngredientsRepository {
    fun createIngredient(ingredient: Ingredient)
    fun deleteIngredient(id: String)
    fun listIngredients(): List<Ingredient>
    fun filterIngredientsByType(type: IngredientType): List<Ingredient>
    fun updateIngredient(id: String, ingredientInput: IngredientInput)
}