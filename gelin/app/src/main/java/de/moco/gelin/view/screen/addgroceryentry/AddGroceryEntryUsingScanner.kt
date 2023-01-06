package de.moco.gelin.view.screen.addgroceryentry

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.moco.gelin.R
import de.moco.gelin.ui.userinterface.ui.theme.brightgreen
import de.moco.gelin.view.gelincomposable.*
import de.moco.gelin.view.gelincomposable.dataclass.PRODUKTHINZUFUEGEN

@Composable
fun AddGroceryEntryUsingScannerView(){
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
            onClick = { /*TODO: save grocery with groceryEntryService.saveGrocery(<grocery object>)*/ },
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
    AddGroceryEntryUsingScannerView()
}
