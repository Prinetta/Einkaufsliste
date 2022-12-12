package de.moco.gelin.view.gelinComposable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO: change UI of dropdown menu
@Composable
inline fun <reified T: Enum<T>> EnumDropdown(defaultText: String, modifier: Modifier = Modifier): MutableState<T> {
    var expanded by remember { mutableStateOf(false) }
    var currentText by remember { mutableStateOf(defaultText) }
    val enumState = remember { mutableStateOf(enumValues<T>().first()) }

    Button(onClick = { expanded = true }, modifier = modifier.fillMaxWidth().padding(10.dp).height(56.dp)) {
        Text(currentText, modifier = Modifier.fillMaxWidth(), fontSize = 18.sp)

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            for (element in enumValues<T>()) {
                val capitalizedName = element.name
                    .lowercase()
                    .replaceFirstChar { it.uppercase() }

                DropdownMenuItem(onClick = {
                    enumState.value = element
                    expanded = false
                    currentText = capitalizedName
                }) { Text(capitalizedName) }
            }
        }
    }

    return enumState
}