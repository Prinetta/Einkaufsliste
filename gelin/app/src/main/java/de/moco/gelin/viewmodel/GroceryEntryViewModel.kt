package de.moco.gelin.viewmodel

import android.app.Application
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import de.moco.gelin.R
import de.moco.gelin.model.groceryEntryService
import de.moco.gelin.model.groceryentry.GroceryEntry
import de.moco.gelin.model.groceryentry.MeasureUnit
import de.moco.gelin.model.product.ProductCategory
import kotlinx.coroutines.launch

// TODO: method for obtaining measurement unit names
class GroceryEntryViewModel(private val app: Application): AndroidViewModel(app) {
    val groceryEntryList = MutableLiveData<List<GroceryEntry>>()

    init {
        viewModelScope.launch {
            observeGroceryEntryList()
        }
    }

    private fun observeGroceryEntryList() {
        groceryEntryService.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val updatedGroceryList = mutableListOf<GroceryEntry>()
                for (child in dataSnapshot.children) {
                    val groceryEntry = child.getValue(GroceryEntry::class.java)
                    if (groceryEntry is GroceryEntry) {
                        updatedGroceryList.add(groceryEntry)
                    }
                }
                groceryEntryList.postValue(updatedGroceryList)
            }

            override fun onCancelled(databaseError: DatabaseError) {
                throw IllegalStateException("Failed with error: ${databaseError.code}")
            }
        })
    }

    // consider using coroutines? :(
    fun categoryTitle(category: ProductCategory): String = app.resources.getString(when (category) {
        ProductCategory.PRODUCE -> R.string.produce
        ProductCategory.DAIRY -> R.string.dairy
        ProductCategory.MEAT -> R.string.meat
        ProductCategory.GRAINS -> R.string.grains
        ProductCategory.BEVERAGE -> R.string.beverage
        ProductCategory.OTHER -> R.string.other
    })

    fun categoryColor(category: ProductCategory): Color = Color(ContextCompat.getColor(app.applicationContext,
        when (category) {
            ProductCategory.PRODUCE -> R.color.pastelgreen
            ProductCategory.DAIRY -> R.color.pastelyellow
            ProductCategory.MEAT -> R.color.pastelred
            ProductCategory.GRAINS -> R.color.pastelorange
            ProductCategory.BEVERAGE -> R.color.pastelblue
            ProductCategory.OTHER -> R.color.pastelpurple
        }
    ))

    fun unitDisplayName(unit: MeasureUnit): String = when (unit) {
        MeasureUnit.ML -> "ml"
        MeasureUnit.L -> "L"
        MeasureUnit.G -> "g"
        MeasureUnit.KG -> "kg"
        MeasureUnit.PACKAGE -> "Packungen"
        MeasureUnit.BOTTLE -> "Flaschen"
        MeasureUnit.CAN -> "Dosen"
        MeasureUnit.SACK -> "Säcke"
        MeasureUnit.UNIT -> "Stück"
    }
}