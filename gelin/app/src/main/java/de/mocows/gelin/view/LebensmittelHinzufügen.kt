package de.mocows.gelin.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.mocows.gelin.R
import de.mocows.gelin.model.GroceryEntryService
import de.mocows.gelin.model.groceryentry.GroceryEntry
import de.mocows.gelin.model.groceryentry.MeasureUnit
import de.mocows.gelin.model.product.Product
import de.mocows.gelin.model.product.ProductCategory
import de.mocows.gelin.ui.userinterface.ui.theme.brightgreen
import de.mocows.gelin.view.gelinComposable.InputFieldWithPrompt
import de.mocows.gelin.view.gelinComposable.SpacerVerticalS

private val groceryEntryService = GroceryEntryService()

private var brand: String? = null
private var category: ProductCategory? = null
private var amount: Double? = null
private var measureUnit: MeasureUnit? = null

@Composable
fun LebensmittelHinzufuegenManuell(){
    var name = remember { mutableStateOf(TextFieldValue()) }
    var brand = remember { mutableStateOf(TextFieldValue()) }
    var category = remember { mutableStateOf(TextFieldValue()) }
    var amount = remember { mutableStateOf(TextFieldValue()) }
    var measureUnit = remember { mutableStateOf(TextFieldValue()) }

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
        category = InputFieldWithPrompt(
            modifier = Modifier.fillMaxWidth(),
            placeholder = stringResource(id = R.string.kategorie)
        )
        Row {
            amount = InputFieldWithPrompt(
                modifier = Modifier.weight(1f),
                placeholder = stringResource(id = R.string.anzahl)
            )
            measureUnit = InputFieldWithPrompt(
                modifier = Modifier.weight(1f),
                placeholder = stringResource(id = R.string.einheit)
            )
        }
        Button(
            onClick = { groceryEntryService.saveGroceryEntry(GroceryEntry(
                Product(
                    name.value.text,
                    brand.value.text,
                    ProductCategory.valueOf(category.value.text)),
                amount.value.text.toDouble(),
                MeasureUnit.valueOf(measureUnit.value.text)
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

