package com.jorbital.jorbichef

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.jorbital.jorbichef.models.Ingredient
import com.jorbital.jorbichef.models.IngredientInput
import com.jorbital.jorbichef.models.IngredientType
import com.jorbital.jorbichef.repository.IngredientsRepository
import com.jorbital.jorbichef.repository.IngredientsRepositoryImpl

fun SchemaBuilder.schema() {
    val repository: IngredientsRepository = IngredientsRepositoryImpl()

    query("ingredients") {
        description = "Retrieve all ingredients"
        resolver { ->
            try {
                repository.listIngredients()
            } catch (e: Exception) {
                emptyList()
            }
        }
    }
    query("ingredientsByType") {
        description = "Retrieve all ingredients of a certain type"
        resolver { type: IngredientType ->
            try {
                repository.filterIngredientsByType(type)
            } catch (e: Exception) {
                emptyList()
            }
        }
    }

    mutation("createIngredient") {
        description = "Create a new ingredient"
        resolver { ingredientInput: IngredientInput ->
            try {
                val id = java.util.UUID.randomUUID().toString()
                val ingredient = Ingredient(id, ingredientInput.name, ingredientInput.type)
                repository.createIngredient(ingredient)
                true
            } catch (e: Exception) {
                false
            }
        }
    }

    inputType<IngredientInput> {
        description = "The input of an ingredient without the identifier"
    }
    type<Ingredient> {
        description = "Ingredient object with attributes for name and type of ingredient"
    }
    enum<IngredientType>()
}