package de.mocows.gelin.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.mocows.gelin.R
import de.mocows.gelin.ui.userinterface.ui.theme.brightgreen
import de.mocows.gelin.view.gelinComposable.*
import de.mocows.gelin.view.gelinComposable.Dataclasses.PRODUKTHINZUFUEGEN

@Composable
fun AddingProductsUseingScanner(){
    Column (
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth(),
            ) {
        Ueberschrift1(name = PRODUKTHINZUFUEGEN)
        SpacerHorizontalS()
        Row(modifier = Modifier.fillMaxWidth().padding(10.dp), Arrangement.Center){
            ImageProdukt()
        }
        SpacerHorizontalS()
        /*TODO Hier bitte den Produkt und Markenname hinzufügen*/
        Ueberschrift2(name = "Produktname")
        Untertitel(name = "Markenname")
        Row {
            InputFieldWithPrompt(
                modifier = Modifier.weight(1f),
                placeholder = stringResource(id = R.string.anzahl)
            )
            InputFieldWithPrompt(
                modifier = Modifier.weight(1f),
                placeholder = stringResource(id = R.string.einheit)
            )
        }
        Button(
            onClick = { /*TODO("call to backend work manager to persist item")*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = brightgreen, contentColor = Color.White)
        ){
            Text(
                modifier = Modifier.padding(5.dp),
                text = stringResource(id = R.string.produkthinzufuegen),
                fontSize = 20.sp
            )
        }

    }
}

@Preview
@Composable
fun AddingProductsUseingScannerPV(){
    AddingProductsUseingScanner()
}
