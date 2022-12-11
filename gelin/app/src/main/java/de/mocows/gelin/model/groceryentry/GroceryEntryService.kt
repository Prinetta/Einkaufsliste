package de.mocows.gelin.model.groceryentry

import com.google.firebase.database.DatabaseReference
import de.mocows.gelin.model.database

class GroceryEntryService {
    private val groceryEntriesRef: DatabaseReference = database.getReference("groceryEntries")

    fun saveGroceryEntry(groceryEntry: GroceryEntry) = groceryEntriesRef
        .child(groceryEntry.product.name)
        .setValue(groceryEntry)
}