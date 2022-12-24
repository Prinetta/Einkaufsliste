package de.moco.gelin.view.gelincomposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import de.moco.gelin.R
import de.moco.gelin.view.screen.angebot
import de.moco.gelin.view.screen.offer.ProduktAngebot

@Composable
fun OfferListView() {
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
                .border(width = 1.dp, color = Color(R.color.mediumgray))) {
            angebot.forEach {
                items(angebot.size) { i, ->
                    Column(modifier = Modifier.padding(10.dp)) {
                        //Image(angebot[i].bild, contentDescription = "Lebensmittel")
                        Ueberschrift2(name = items[i].produktName)
                        Text(text = items[i].marke)
                        Row {
                            Image(painter = painterResource(id = R.drawable.ic_location_green_24),
                                contentDescription = "")
                            SpacerVerticalS()
                            Text(text = items[i].shopadresse)

                        }
                    }
            }
        }
    }
}





