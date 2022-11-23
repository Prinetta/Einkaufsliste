package de.mocows.gelin.view.gelinComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import de.mocows.gelin.view.angebot
import de.mocows.gelin.view.gelinComposable.Dataclasses.ProduktAngebot

@Composable
fun ProduktAnzeigeAngebot() {
    val items by remember {
        mutableStateOf(
            (1..20).map {
                ProduktAngebot(
                    produktName = "$it",
                    marke = "$it",
                    preis = 1.0f,
                    shopadresse ="$it",
                    bild = R.drawable.lebensmittel
                )
            }
        )
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .border(width = 1.dp, color = Color(R.color.brightgray))) {
/*        for){
        items(angebot.size){
            Column (modifier = Modifier
                .padding(10.dp)) {
                Image(angebot[i].bild, contentDescription = "Lebensmittel")
                Ueberschrift2(name = items[i].produktName)
                Text(text = items[i].marke)
                Row {
                    Image(painter = painterResource(id = R.drawable.ic_location_green_24), contentDescription = "")
                    SpacerVerticalS()
                    Text(text = items[i].shopadresse)

                }
            }
        }*/
        }
    }





