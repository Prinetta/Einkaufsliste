package de.moco.gelin.model.groceryentry

import de.moco.gelin.model.product.Product

data class GroceryEntry(val product: Product, val amount: Double, val unit: MeasureUnit) {
    // no args constructor necessary for realtime database retrieval
    constructor() : this(Product(), 0.0, MeasureUnit.UNIT)
}