package com.juliasz.ordersapi.model

data class Product (
    val name: String,
    val code: String,
    val date: String,
    val dimension: Dimension
)
data class Dimension(
    val weight: Double,
    val height: Double,
    val width: Double,
    val length: Double
)