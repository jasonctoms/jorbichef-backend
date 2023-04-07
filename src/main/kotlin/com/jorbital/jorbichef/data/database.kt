package com.jorbital.jorbichef.data

import com.jorbital.jorbichef.models.*

val tags = mutableListOf(
    Tag(id = "0", name = "seasoning", resourceId = "tag_seasoning"),
    Tag(id = "1", name = "vegetable", resourceId = "tag_vegetable"),
    Tag(id = "2", name = "fruit", resourceId = "tag_fruit"),
    Tag(id = "3", name = "vegan", resourceId = "tag_vegan"),
    Tag(id = "4", name = "protein", resourceId = "tag_protein"),
)

val ingredients = mutableListOf(
    Ingredient(id = "0", name = "salt", resourceId = "ingredient_salt", tags = listOf(tags[0])),
    Ingredient(id = "1", name = "pepper", resourceId = "ingredient_pepper", tags = listOf(tags[0])),
    Ingredient(id = "2", name = "parsley", resourceId = "ingredient_parsley", tags = listOf(tags[0])),
    Ingredient(id = "3", name = "ribeye", resourceId = "ingredient_ribeye", tags = listOf(tags[4])),
    Ingredient(id = "4", name = "tofu", resourceId = "ingredient_tofu", tags = listOf(tags[4], tags[3])),
    Ingredient(id = "5", name = "carrot", resourceId = "ingredient_carrot", tags = listOf(tags[1])),
    Ingredient(id = "6", name = "lettuce", resourceId = "ingredient_lettuce", tags = listOf(tags[1])),
    Ingredient(id = "7", name = "brussel sprouts", resourceId = "ingredient_brussel_sprouts", tags = listOf(tags[1])),
    Ingredient(id = "8", name = "mango", resourceId = "ingredient_mango", tags = listOf(tags[2])),
)

val recipes = mutableListOf(
    Recipe(
        id = "1",
        userId = "demo",
        name = "Demo Salad",
        ingredients = listOf(
            RecipeIngredient(id = "1", amount = "1 bunch", ingredient = ingredients[6]),
            RecipeIngredient(id = "2", amount = "1 handful", ingredient = ingredients[7]),
            RecipeIngredient(id = "3", amount = "1 diced", ingredient = ingredients[8]),
        ),
        instructions = "Cut things up and mix them together. Probably cook the brussel sprouts first. What a weird salad.",
        url = null,
        imageUrl = null,
        tags = listOf(tags[1], tags[2], tags[3])
    ),
    Recipe(
        id = "2",
        userId = "demo",
        name = "Tofu stir fry",
        ingredients = listOf(
            RecipeIngredient(id = "4", amount = "1 block", ingredient = ingredients[4]),
            RecipeIngredient(id = "5", amount = "1 bunch", ingredient = ingredients[5]),
            RecipeIngredient(id = "6", amount = "1 handful", ingredient = ingredients[7]),
            RecipeIngredient(id = "7", amount = "1 diced", ingredient = ingredients[8]),
        ),
        instructions = "Cut things up and fry them in oil.",
        url = null,
        imageUrl = null,
        tags = listOf(tags[1], tags[3], tags[4])
    )
)

val weeklyMenus = mutableListOf(
    WeeklyMenu(
        id = "1",
        userId = "demo",
        monday = listOf(recipes[0]),
        tuesday = listOf(recipes[1]),
        wednesday = emptyList(),
        thursday = listOf(recipes[1]),
        friday = listOf(recipes[0]),
        saturday = listOf(recipes[1]),
        sunday = listOf(recipes[0]),
    )
)