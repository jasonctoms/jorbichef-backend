package com.jorbital.jorbichef.repository

import com.jorbital.jorbichef.data.ingredients
import com.jorbital.jorbichef.models.Ingredient
import com.jorbital.jorbichef.models.IngredientInput
import com.jorbital.jorbichef.models.IngredientType

class IngredientsRepositoryImpl : IngredientsRepository {
    override fun createIngredient(ingredient: Ingredient) {
        ingredients.add(ingredient)
    }

    override fun deleteIngredient(id: String) {
        ingredients.removeIf { it.id == id }
    }

    override fun listIngredients(): List<Ingredient> {
        return ingredients
    }

    override fun filterIngredientsByType(type: IngredientType): List<Ingredient> {
        return ingredients.filter { it.type == type }
    }

    override fun updateIngredient(id: String, ingredientInput: IngredientInput) {
        ingredients.find { it.id == id }?.apply {
            name = ingredientInput.name
            type = ingredientInput.type
        }
    }
}