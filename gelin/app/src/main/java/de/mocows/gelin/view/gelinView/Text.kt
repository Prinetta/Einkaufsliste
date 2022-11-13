package de.mocows.gelin.view.gelinView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ueberschrift1(name: Int) {
    Text(text = "$name!", fontSize = 24.sp)
}

@Composable
fun Ueberschrift2(name: Int) {
    Text(text = "$name!", fontSize = 18.sp)
}

@Composable
fun Ueberschrift3(name: Int) {
    Text(text = "$name!", fontSize = 16.sp)
}

@Composable
fun Fliesstext(name: Int) {
    Text(text = "$name!", fontSize = 12.sp)
}

@Composable
fun FliesstextString(name: String){
    Text(text = "$name!", fontSize = 12.sp)
}

@Composable
fun untertitel(name: Int) {
    Text(text = "$name!", fontSize = 10.sp)
}

@Composable
fun ImputFieldOhneEingabeText(name: String) {
    Column(Modifier.padding(16.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        Text(text= "$name")
    }
}

@Composable
fun ImputFieldMitEingabeText(name: String) {
    Column(Modifier.padding(16.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it
            }
        )
        Text(text= "$name" + textState.value.text)
    }
}
