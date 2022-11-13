package de.mocows.gelin.view

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import de.mocows.gelin.view.gelinComposable.*

@Composable
fun Login(){
    Row(
        modifier = Modifier
            .background(R.drawable.background_green)
    ) {
                LogoImage()
                CardViewLogin()

    }
}

@Preview
@Composable
fun CardViewLoginPreview(){
    Login()
}

@Composable
fun CardViewLogin() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Ueberschrift1(name = R.string.login)
            Fliesstext(name = R.string.begrueßungsTextLogin)
            ImputFieldOhneEingabeText(name = "Usename")
            ImputFieldMitEingabeText(name = "Passwort: ")
            Button()
        }
    }
}

@Preview
@Composable
fun LoginPreview(){
    CardViewLogin()
}




@Composable
fun Button() {
    androidx.compose.material.Button(onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Color.Green
        ),
        modifier = Modifier.fillMaxWidth(1f)
    ) {
        Fliesstext(name = R.string.login)
    }
}

@Preview
@Composable
fun ButtonPreview(){
    Button()
}