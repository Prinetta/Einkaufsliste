package de.moco.gelin.view.screen.grocerylist


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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.moco.gelin.model.groceryentry.GroceryEntry
import de.moco.gelin.view.gelincomposable.Fliesstext
import de.moco.gelin.view.gelincomposable.SpacerHorizontalXS
import de.moco.gelin.view.gelincomposable.SpacerHorizontalXXS
import de.moco.gelin.viewmodel.GroceryEntryViewModel

@Composable
fun GroceryEntryItem(groceryEntry: GroceryEntry, categoryColor: Color, viewModel: GroceryEntryViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        Row (
            modifier = Modifier.background(categoryColor),
            verticalAlignment = Alignment.CenterVertically
        ){
            BoughtCheckbox()

            SpacerHorizontalXS()
            Fliesstext(name = groceryEntry.product.name)

            SpacerHorizontalXS()
            Fliesstext(name = shortDoubleString(groceryEntry.amount))

            SpacerHorizontalXXS()
            Fliesstext(name = viewModel.unitDisplayName(groceryEntry.unit))
        }
    }
}

private fun shortDoubleString(double: Double): String = if (double - double.toInt() == 0.0) {
    double.toInt().toString()
} else {
    double.toString()
}

@Composable
fun BoughtCheckbox() {
    val checkedState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}
