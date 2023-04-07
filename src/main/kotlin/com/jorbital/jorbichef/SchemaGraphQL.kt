package com.jorbital.jorbichef

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.jorbital.jorbichef.models.*
import com.jorbital.jorbichef.repository.JorbichefRepository
import com.jorbital.jorbichef.repository.JorbichefRepositoryImpl

fun SchemaBuilder.schema() {
    val repository: JorbichefRepository = JorbichefRepositoryImpl()

    query("tags") {
        description = "Retrieve all tags"
        resolver { ->
            try {
                repository.getTags()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    query("ingredients") {
        description = "Retrieve all ingredients"
        resolver { ->
            try {
                repository.getIngredients()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    query("recipes") {
        description = "Retrieve all recipes"
        resolver { ->
            try {
                repository.getRecipes()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    query("weeklyMenu") {
        description = "Retrieve the weekly menu"
        resolver { ->
            try {
                repository.getWeeklyMenu()
            } catch (e: Exception) {
                null
            }
        }
    }

    mutation("createTag") {
        description = "Create a new tag"
        resolver { tagName: String ->
            try {
                val id = java.util.UUID.randomUUID().toString()
                repository.createTag(Tag(id = id, name = tagName))
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("createIngredient") {
        description = "Create a new ingredient"
        resolver { ingredientInput: IngredientInput ->
            try {
                val id = java.util.UUID.randomUUID().toString()
                val ingredient = Ingredient(id = id, name = ingredientInput.name, tags = ingredientInput.tags)
                repository.createIngredient(ingredient)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("createRecipe") {
        description = "Create a new recipe"
        resolver { recipe: Recipe ->
            try {
                val id = java.util.UUID.randomUUID().toString()
                repository.createRecipe(recipe.copy(id = id))
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("updateWeeklyMenu") {
        description = "Update the weekly menu"
        resolver { weeklyMenu: WeeklyMenu ->
            try {
                repository.updateWeeklyMenu(weeklyMenu)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("deleteTag") {
        description = "Delete a tag"
        resolver { id: String ->
            try {
                repository.deleteTag(id)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("deleteIngredient") {
        description = "Delete an ingredient"
        resolver { id: String ->
            try {
                repository.deleteIngredient(id)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    mutation("deleteRecipe") {
        description = "Delete a recipe"
        resolver { id: String ->
            try {
                repository.deleteRecipe(id)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    type<Tag> {
        description = "Tag object with attributes for id, name, and optional resource id and user id"
    }
    type<Ingredient> {
        description = "Ingredient object with attributes for id, name, tags, and optional resource id and user id"
    }
    inputType<IngredientInput> {
        description = "The input of an ingredient without the identifier"
    }
    type<Recipe> {
        description = "Recipe object with attributes for id, name, ingredients, instructions, url, image url, and tags"
    }
    type<RecipeIngredient> {
        description = "RecipeIngredient object with attributes for id, amount, and ingredient"
    }
    type<WeeklyMenu> {
        description = "WeeklyMenu object with attributes for id, user id, and a list of recipes"
    }
}