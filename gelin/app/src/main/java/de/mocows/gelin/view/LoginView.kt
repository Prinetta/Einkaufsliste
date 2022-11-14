package de.mocows.gelin.view

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import de.mocows.gelin.view.gelinComposable.*

@Composable
fun LoginView(){
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.darkgreen))
            .fillMaxSize(),

    ) {
        LogoImage()
        CardViewLogin()
    }
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
            Ueberschrift1(stringResource(id = R.string.login))
            Fliesstext(stringResource(id =  R.string.begrueßungsTextLogin))
            ImputFieldOhneEingabeText(stringResource(id = R.string.login))
            ImputFieldMitEingabeText(stringResource(id = R.string.passwort))
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
            backgroundColor = colorResource(id = R.color.darkgreen)
        ),
        modifier = Modifier.fillMaxWidth(1f)
    ) {
        Fliesstext(stringResource(id = R.string.login))
    }
}

@Preview
@Composable
fun ButtonPreview(){
    Button()
}