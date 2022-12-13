package de.moco.gelin.view.screen.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDrawStyle.Unspecified.color
import androidx.compose.ui.unit.dp
import de.moco.gelin.view.gelincomposable.*
import de.moco.gelin.ui.theme.darkgreen as darkgreen

@Composable
fun RegistrationView(){
    Column(
        modifier = Modifier
            .background(color = darkgreen)
            .fillMaxSize(),

        ) {
        LogoImage()
        CardViewRegistration()
    }
}

@Composable
fun CardViewRegistration() {
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
            InputFieldOhneEingabeText(stringResource(id = R.string.name))
            InputFieldOhneEingabeText(stringResource(id = R.string.username))
            InputFieldMitEingabeText(stringResource(id = R.string.passwort))
            InputFieldMitEingabeText(stringResource(id = R.string.passwortBestaetigen))
            RegisterButton()
        }
    }
}

@Composable
fun RegisterButton() {
    androidx.compose.material.Button(onClick = { /* Do something! */ },
        colors = ButtonDefaults.textButtonColors(
           backgroundColor = darkgreen
        ),
        modifier = Modifier.fillMaxWidth(1f)
            .fillMaxHeight(2f)
    ) {
        Fliesstext(stringResource(id = R.string.registrieren))
    }
}

