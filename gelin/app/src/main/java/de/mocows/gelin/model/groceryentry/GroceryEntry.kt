package de.mocows.gelin.model.groceryentry

import de.mocows.gelin.model.product.Product

class GroceryEntry(private val product: Product,
                   private val amount: Double,
                   private val unit: MeasureUnit)