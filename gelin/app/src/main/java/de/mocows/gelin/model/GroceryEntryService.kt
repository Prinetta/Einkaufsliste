package de.mocows.gelin.model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import de.mocows.gelin.model.groceryentry.GroceryEntry

// TODO: relocate main database into different file
val database: FirebaseDatabase = FirebaseDatabase.getInstance()
val databaseRef: DatabaseReference = database.reference

private val groceryEntriesRef: DatabaseReference = database.getReference("groceryEntries")

class GroceryEntryService {
    fun saveGroceryEntry(groceryEntry: GroceryEntry) = groceryEntriesRef
        .child(groceryEntry.product.name)
        .setValue(groceryEntry)
}