package de.moco.gelin.model.groceryentry

import com.google.firebase.database.DatabaseReference
import de.moco.gelin.model.database

class GroceryEntryService {
    private val groceryEntriesRef: DatabaseReference = database.getReference("groceryEntries")

    fun saveGroceryEntry(groceryEntry: GroceryEntry) = groceryEntriesRef
        .child(groceryEntry.product.name)
        .setValue(groceryEntry)
}