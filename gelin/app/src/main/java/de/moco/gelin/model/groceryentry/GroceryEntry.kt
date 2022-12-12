package de.moco.gelin.model.groceryentry

import de.moco.gelin.model.product.Product

data class GroceryEntry(val product: Product, val amount: Double, val unit: MeasureUnit)