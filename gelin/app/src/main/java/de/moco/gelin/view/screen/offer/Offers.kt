package de.moco.gelin.view.screen

import androidx.compose.runtime.Composable
import de.moco.gelin.view.gelincomposable.OfferListView
import de.moco.gelin.view.gelincomposable.Ueberschrift1


@Composable
fun OfferView(){
    Ueberschrift1(name = "Angebot der Woche")
    OfferListView()
    

}