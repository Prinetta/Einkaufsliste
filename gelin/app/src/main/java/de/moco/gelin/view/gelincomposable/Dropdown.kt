package de.moco.gelin.view.gelincomposable

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.moco.gelin.R

// TODO: change UI of dropdown menu
@Composable
inline fun <reified T: Enum<T>> EnumDropdown(
    defaultText: String,
    crossinline mapToString: (T) -> String = { capitalizedEnumName(it) },
    promptColor: Color = colorResource(R.color.darkgray),
    modifier: Modifier = Modifier
): MutableState<T> {
    var expanded by remember { mutableStateOf(false) }
    var textColor by remember { mutableStateOf(promptColor) }
    var currentText by remember { mutableStateOf(defaultText) }
    val enumState = remember { mutableStateOf(enumValues<T>().first()) }

    Button(
        onClick = { expanded = true },
        modifier = modifier.fillMaxWidth()
            .padding(10.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.lightgray))
    ) {
        Row {
            Text(
                currentText,
                fontSize = 18.sp,
                color = textColor,
                fontWeight = FontWeight.Normal
            )
            Spacer(Modifier.weight(1f))
            Icon(Icons.Default.ArrowDropDown, "Ausklappen")
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            for (element in enumValues<T>()) {
                val displayedName = mapToString(element)

                DropdownMenuItem(onClick = {
                    enumState.value = element
                    expanded = false
                    currentText = displayedName
                    textColor = Color.Black
                }) { Text(displayedName) }
            }
        }
    }

    return enumState
}

inline fun <reified T: Enum<T>> capitalizedEnumName(enumValue: T): String = enumValue.name
    .lowercase()
    .replaceFirstChar { it.uppercase() }