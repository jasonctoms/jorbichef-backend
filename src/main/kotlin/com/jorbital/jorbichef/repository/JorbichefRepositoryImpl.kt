package com.jorbital.jorbichef.repository

import com.jorbital.jorbichef.data.ingredients
import com.jorbital.jorbichef.data.recipes
import com.jorbital.jorbichef.data.tags
import com.jorbital.jorbichef.data.weeklyMenus
import com.jorbital.jorbichef.models.Ingredient
import com.jorbital.jorbichef.models.Recipe
import com.jorbital.jorbichef.models.Tag
import com.jorbital.jorbichef.models.WeeklyMenu

class JorbichefRepositoryImpl : JorbichefRepository {

    // TODO: authenticate user and get userId
    private val userId = "demo"

    override fun getTags(): List<Tag> {
        return tags.filter { it.userId == null || it.userId == userId }
    }

    override fun createTag(tag: Tag) {
        tags.add(tag.copy(userId = userId))
    }

    override fun deleteTag(id: String) {
        val tag = tags.find { it.id == id }
        if (tag?.userId != null) {
            tags.remove(tag)
        }
    }

    override fun getIngredients(): List<Ingredient> {
        return ingredients.filter { it.userId == null || it.userId == userId }
    }

    override fun createIngredient(ingredient: Ingredient) {
        ingredients.add(ingredient.copy(userId = userId))
    }

    override fun deleteIngredient(id: String) {
        val ingredient = ingredients.find { it.id == id }
        if (ingredient?.userId != null) {
            ingredients.remove(ingredient)
        }
    }

    override fun getRecipes(): List<Recipe> {
        return recipes.filter { it.userId == userId }
    }

    override fun createRecipe(recipe: Recipe) {
        recipes.add(recipe.copy(userId = userId))
    }

    override fun deleteRecipe(id: String) {
        val recipe = recipes.find { it.id == id }
        recipe?.let {
            recipes.remove(recipe)
        }
    }

    override fun getWeeklyMenu(): WeeklyMenu? {
        return weeklyMenus.find { it.userId == userId }
    }

    override fun updateWeeklyMenu(weeklyMenu: WeeklyMenu) {
        val menu = weeklyMenus.find { it.id == userId }
        menu?.let {
            weeklyMenus.remove(menu)
            weeklyMenus.add(weeklyMenu)
        }
    }
}