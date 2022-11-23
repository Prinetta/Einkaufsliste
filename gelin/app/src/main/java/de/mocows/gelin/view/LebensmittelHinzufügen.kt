package de.mocows.gelin.view


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import de.mocows.gelin.R
import de.mocows.gelin.view.gelinComposable.ImputFieldOhneEingabeText

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

