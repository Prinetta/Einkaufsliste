package de.moco.gelin.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import de.moco.gelin.R
import de.moco.gelin.model.groceryentry.GroceryEntry
import de.moco.gelin.model.groceryentry.GroceryEntryService
import de.moco.gelin.model.groceryentry.MeasureUnit
import de.moco.gelin.model.product.Product
import de.moco.gelin.model.product.ProductCategory
import de.moco.gelin.ui.userinterface.ui.theme.brightgreen
import de.moco.gelin.view.gelincomposable.EnumDropdown
import de.moco.gelin.view.gelincomposable.InputFieldWithPrompt
import de.moco.gelin.view.gelincomposable.SpacerVerticalS
import de.moco.gelin.viewmodel.GroceryEntryViewModel

// TODO: suggest product with auto completion
// GroceryEntryViewModel gets autowired instead of passed from GroceryListView, not ideal but should be ok
@Composable
fun AddGroceryEntryView(viewModel: GroceryEntryViewModel = viewModel()) {
    var name: MutableState<TextFieldValue>
    var brand: MutableState<TextFieldValue>
    var category: MutableState<ProductCategory>
    var amount = remember { mutableStateOf(TextFieldValue()) }
    var measureUnit = remember { mutableStateOf(MeasureUnit.UNIT) }

    Column {
        SpacerVerticalS()
        name = InputFieldWithPrompt(
            modifier = Modifier.fillMaxWidth(),
            placeholder = stringResource(id = R.string.lebensmittelHinzufuegen)
        )
        brand = InputFieldWithPrompt(
            modifier = Modifier.fillMaxWidth(),
            placeholder = stringResource(id = R.string.marke)
        )
        category = EnumDropdown("Kategorie", mapToString = { viewModel.categoryTitle(it) })


        Row {
            amount = InputFieldWithPrompt(
                modifier = Modifier.weight(1f),
                placeholder = stringResource(id = R.string.anzahl)
            )
            measureUnit = EnumDropdown(
                "Einheit",
                mapToString = { viewModel.unitDisplayName(it) },
                modifier = Modifier.weight(1f)
            )
        }

        Button(
            onClick = { viewModel.saveGroceryEntry(GroceryEntry(
                Product(
                    name.value.text,
                    brand.value.text.ifEmpty { null },
                    category.value
                ),
                amount.value.text.toDouble(),
                measureUnit.value
            )) },
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = brightgreen, contentColor = Color.White)
        ) {
            Text(
                modifier = Modifier.padding(5.dp),
                text = stringResource(id = R.string.produkthinzufuegen),
                fontSize = 20.sp
            )
        }
    }
}

