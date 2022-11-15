package de.mocows.gelin.view.gelinComposable


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import de.mocows.gelin.R

@Composable
fun LebensmittelHinzufuegenManuell(){
    Column() {
        ImputFieldOhneEingabeText(stringResource(id = R.string.lebensmittelHinzufuegen))
        Row(){
            ImputFieldOhneEingabeText(name = stringResource(id = R.string.anzahl))
            ImputFieldOhneEingabeText(name = stringResource(id = R.string.einheit))
        }
    }
}

