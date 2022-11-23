package de.mocows.gelin.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
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
            InputFieldOhneEingabeText(stringResource(id = R.string.login))
            InputFieldMitEingabeText(stringResource(id = R.string.passwort))
            LoginButton()
        }
    }
}


@Composable
fun LoginButton() {
    androidx.compose.material.Button(onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = colorResource(id = R.color.darkgreen)
        ),
        modifier = Modifier.fillMaxWidth(1f)
    ) {
        Fliesstext(stringResource(id = R.string.login))
    }
}

