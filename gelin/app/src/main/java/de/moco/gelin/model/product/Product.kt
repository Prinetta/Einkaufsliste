package de.moco.gelin.model.product

data class Product(val name: String, val brand: String? = null, val category: ProductCategory)