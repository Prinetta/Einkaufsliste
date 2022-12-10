package de.mocows.gelin.model.groceryentry

import de.mocows.gelin.model.product.Product

data class GroceryEntry(val product: Product, val amount: Double, val unit: MeasureUnit)