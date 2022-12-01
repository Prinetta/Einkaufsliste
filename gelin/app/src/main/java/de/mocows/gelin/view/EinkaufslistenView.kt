package de.mocows.gelin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.mocows.gelin.R
import de.mocows.gelin.view.gelinComposable.*
import de.mocows.gelin.view.gelinComposable.Dataclasses.EINKAUFSLISTE
import de.mocows.gelin.view.gelinComposable.Dataclasses.PRODUKTHINZUFUEGEN

@Composable
fun EinkaufslisteView(navController: NavHostController) {

    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SpacerVerticalXS()
        BudgetView()
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp)
        ) {// add groceries
            LebensmittelHinzufuegenButton(navController)
        }
        Ueberschrift1(name = stringResource(id = R.string.einkaufsliste))
        CardViewCategory(stringResource(R.string.obstUndGemuese), R.color.lightgreen)
        CardViewCategory(stringResource(R.string.milchprodukte), R.color.lightyellow)
        CardViewCategory(stringResource(R.string.fleischprodukte), R.color.pastellred)
    }
}

@Composable
fun BudgetView() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Ueberschrift2(name = stringResource(id = R.string.budget))
        SpacerHorizontalXL()
        Ueberschrift2(name = "[XX,00] €")
        Spacer(Modifier.weight(1f))
        BearbeitenIconButton()
    }
}

@Composable
fun CardViewCategory(categoryTitle: String, categoryColorId: Int) {
    Card(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .padding(vertical = 6.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(id = categoryColorId))
                .padding(5.dp)

        ) {
            Box(modifier = Modifier.padding(horizontal = 5.dp)){
                Ueberschrift3(categoryTitle)
            }
            //Das soll eine Liste werden
            EinkaufsItemView(categoryColorId)
            EinkaufsItemView(categoryColorId)
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
fun LebensmittelHinzufuegenButton(navController: NavHostController) {
    Button(
        modifier = Modifier
            .fillMaxWidth(1f),
        colors = ButtonDefaults.textButtonColors(
                backgroundColor = colorResource(id = R.color.darkgreen),
                contentColor =  colorResource(id = R.color.white)
            ),
        onClick = {
            navController.navigate(PRODUKTHINZUFUEGEN) {
                popUpTo(EINKAUFSLISTE){ inclusive = true }
            }
        }){
        Fliesstext(name = stringResource(id = R.string.lebensmittelHinzufuegen))
        SpacerHorizontalXS()
        Image(
            painterResource(id = R.drawable.ic_search_white),
            contentDescription = stringResource(id = R.string.budgetAendern),
            modifier = Modifier
                .size(30.dp, 30.dp))
    }
}
