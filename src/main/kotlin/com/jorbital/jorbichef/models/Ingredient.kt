package com.jorbital.jorbichef.models

data class Ingredient(
    val id: String,
    val name: String,
    val resourceId: String? = null,
    val userId: String? = null,
    val tags: List<Tag>,
)

data class IngredientInput(val name: String, val tags: List<Tag>)