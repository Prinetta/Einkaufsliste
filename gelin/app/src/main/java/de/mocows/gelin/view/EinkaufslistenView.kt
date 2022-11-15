package de.mocows.gelin.view.gelinComposable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import kotlin.math.round

@Composable
fun EinkaufslisteView() {
    Column {
        SpacerHorizontalXS()
        Ueberschrift2(name = stringResource(id = R.string.einkaufsliste))
        SpacerHorizontalS()
        LebensmittelHinzufuegenButton()
        SpacerVerticalM()
        Row {
            Ueberschrift2(name = stringResource(id = R.string.budget))
            SpacerVerticalXL()
            BearbeitenIconButton()
        }
        CardviewObst()
    }
}

@Composable
fun CardviewObst() {
    Card(
        modifier = Modifier
            .padding(1.dp)
            .background(colorResource(id = R.color.white))
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .background(colorResource(id = R.color.pastelgreen))

        ) {
            SpacerHorizontalS()
            Ueberschrift2(stringResource(id = R.string.obstUndGemuese))
            //Das soll eine Liste werden
            EinkaufsItemView()
            EinkaufsItemView()
        }
    }
}

@Composable
fun BearbeitenIconButton(){
    Button(
        colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorResource(id = R.color.white),
            ),
        onClick = {}) {
        Image(
            painterResource(id = R.drawable.ic_pencil_48),
            contentDescription ="Budget bearbeiten",
            modifier = Modifier
                .size(25.dp, 25.dp)
        )
    }
}
@Composable
fun LebensmittelHinzufuegenButton(){
    Button(
        modifier = Modifier
            .fillMaxWidth(0.9f),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorResource(id = R.color.darkgreen),
                contentColor =  colorResource(id = R.color.white)
            ),
        onClick = {

        }) {
        Fliesstext(name = stringResource(id = R.string.lebensmittelHinzufuegen))
        SpacerVerticalXS()
        Image(
            painterResource(id = R.drawable.ic_search_white),
            contentDescription = stringResource(id = R.string.budgetAendern),
            modifier = Modifier
                .size(30.dp, 30.dp))
    }
}
