package de.mocows.gelin.view.gelinComposable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ueberschrift1(name: String) {
    Text(text = "$name!", fontSize = 24.sp)
}

@Composable
fun Ueberschrift2(name: String) {
    Text(text = "$name!", fontSize = 18.sp)
}

@Composable
fun Ueberschrift3(name: String) {
    Text(text = "$name!", fontSize = 16.sp)
}

@Composable
fun Fliesstext(name: String) {
    Text(text = "$name!", fontSize = 12.sp)
}

@Composable
fun FliesstextString(name: String){
    Text(text = "$name!", fontSize = 12.sp)
}

@Composable
fun untertitel(name: String) {
    Text(text = "$name!", fontSize = 10.sp)
}

@Composable
fun InputFieldOhneEingabeText(name: String) {
    Column(Modifier.padding(10.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        Text(text = name)
    }
}

@Composable
fun InputFieldMitEingabeText(name: String) {
    Column(Modifier.padding(10.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it }
        )
        Text(text = name + textState.value.text)
    }
}

@Composable
fun InputFieldWithPrompt(modifier: Modifier = Modifier, placeholder: String, fontSize: Int = 18) {
    Box(modifier.padding(10.dp)) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            modifier = modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = fontSize.sp),
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text(text = placeholder, fontSize = fontSize.sp) }
        )
    }
}
