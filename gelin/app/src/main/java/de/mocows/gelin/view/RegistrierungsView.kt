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
fun RegistrierungsView(){
    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.darkgreen))
            .fillMaxSize(),

        ) {
        LogoImage()
        CardViewRegistierung()
    }
}

@Composable
fun CardViewRegistierung() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Ueberschrift1(stringResource(id = R.string.registrieren))
            Fliesstext(stringResource(id =  R.string.begrueßungsTextRegistrierung))
            ImputFieldOhneEingabeText(stringResource(id = R.string.name))
            ImputFieldOhneEingabeText(stringResource(id = R.string.username))
            ImputFieldMitEingabeText(stringResource(id = R.string.passwort))
            ImputFieldMitEingabeText(stringResource(id = R.string.passwortBestaetigen))
            RegistrierungsButton()
        }
    }
}

@Composable
fun RegistrierungsButton() {
    androidx.compose.material.Button(onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = colorResource(id = R.color.darkgreen)
        ),
        modifier = Modifier.fillMaxWidth(1f)
            .fillMaxHeight(2f)
    ) {
        Fliesstext(stringResource(id = R.string.registrieren))
    }
}

