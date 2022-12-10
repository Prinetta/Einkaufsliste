package de.mocows.gelin.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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

@Composable
fun LebensmittelHinzufuegenManuell(){
    var name = remember { mutableStateOf(TextFieldValue()) }
    var brand = remember { mutableStateOf(TextFieldValue()) }
    var category = remember { mutableStateOf(ProductCategory.OTHER) }
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

        // TODO: create method for dropdown menu
        // TODO: change UI of dropdown menu
        var categoriesExpanded by remember { mutableStateOf(false) }
        var categoryText by remember { mutableStateOf("Kategorie") }

        Button(onClick = { categoriesExpanded = true },
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(10.dp)
                   .height(56.dp)) {
            Text(categoryText, modifier = Modifier.fillMaxWidth(), fontSize = 18.sp)
            DropdownMenu(
                expanded = categoriesExpanded,
                onDismissRequest = { categoriesExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                for (productCategory in ProductCategory.values()) {
                    val capitalizedName = productCategory.name
                        .lowercase()
                        .replaceFirstChar { it.uppercase() }

                    DropdownMenuItem(onClick = {
                        category.value = productCategory
                        categoriesExpanded = false
                        categoryText = capitalizedName
                    }) {
                        Text(capitalizedName)
                    }
                }
            }
        }


        Row {
            amount = InputFieldWithPrompt(
                modifier = Modifier.weight(1f),
                placeholder = stringResource(id = R.string.anzahl)
            )

            var measureUnitsExpanded by remember { mutableStateOf(false) }
            var measureUnitText by remember { mutableStateOf("Einheit") }

            Button(onClick = { measureUnitsExpanded = true },
                   modifier = Modifier
                       .weight(1f)
                       .fillMaxWidth()
                       .padding(10.dp)
                       .height(56.dp)) {
                Text(measureUnitText, modifier = Modifier.fillMaxWidth(), fontSize = 18.sp)
                DropdownMenu(
                    expanded = measureUnitsExpanded,
                    onDismissRequest = { measureUnitsExpanded = false }
                ) {
                    for (unit in MeasureUnit.values()) {
                        // TODO: do not capitalize specific unit abbreviations like ml, g, kg...
                        val capitalizedName = unit.name
                            .lowercase()
                            .replaceFirstChar { it.uppercase() }

                        DropdownMenuItem(onClick = {
                            measureUnit.value = unit
                            measureUnitsExpanded = false
                            measureUnitText = capitalizedName
                        }) {
                            Text(capitalizedName)
                        }
                    }
                }
            }
        }

        Button(
            onClick = { groceryEntryService.saveGroceryEntry(GroceryEntry(
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

