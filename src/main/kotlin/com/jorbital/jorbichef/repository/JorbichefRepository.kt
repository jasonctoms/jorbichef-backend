package com.jorbital.jorbichef.repository

import com.jorbital.jorbichef.models.Ingredient
import com.jorbital.jorbichef.models.Recipe
import com.jorbital.jorbichef.models.Tag
import com.jorbital.jorbichef.models.WeeklyMenu

interface JorbichefRepository {
    fun getTags(): List<Tag>
    fun createTag(tag: Tag)
    fun deleteTag(id: String)
    fun getIngredients(): List<Ingredient>
    fun createIngredient(ingredient: Ingredient)
    fun deleteIngredient(id: String)
    fun getRecipes(): List<Recipe>
    fun createRecipe(recipe: Recipe)
    fun deleteRecipe(id: String)
    fun getWeeklyMenu(): WeeklyMenu?
    fun updateWeeklyMenu(weeklyMenu: WeeklyMenu)
}