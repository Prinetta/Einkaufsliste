package de.moco.gelin.view.screen.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.moco.gelin.view.gelincomposable.*
import de.moco.gelin.view.gelincomposable.dataclass.*
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
            Ueberschrift1(REGISTIERUNG)
            Fliesstext("")
            InputFieldOhneEingabeText(NAME)
            InputFieldOhneEingabeText(USERBEISPIELNAME)
            InputFieldMitEingabeText(PASSWORD)
            InputFieldMitEingabeText(PASSWORTBESTAETIGEN)
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
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(2f)
    ) {
        Fliesstext(REGISTIERUNG)
    }
}

