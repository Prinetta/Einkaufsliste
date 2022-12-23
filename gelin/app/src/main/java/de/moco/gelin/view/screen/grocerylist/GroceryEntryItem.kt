package de.moco.gelin.view.gelincomposable


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import de.moco.gelin.model.groceryentry.GroceryEntry

@Composable
fun GroceryEntryItem(groceryEntry: GroceryEntry, categoryColorId: Int){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        Row (
            modifier = Modifier
                .background(colorResource(id = categoryColorId)),
            verticalAlignment = Alignment.CenterVertically
        ){
            BoughtCheckbox()

            SpacerHorizontalXS()
            Fliesstext(name = groceryEntry.product.name)

            SpacerHorizontalXS()
            Fliesstext(name = groceryEntry.amount.toString())

            SpacerHorizontalXS()
            Fliesstext(name = groceryEntry.unit.name)
        }
    }

}


@Composable
fun BoughtCheckbox() {
    val checkedState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}
