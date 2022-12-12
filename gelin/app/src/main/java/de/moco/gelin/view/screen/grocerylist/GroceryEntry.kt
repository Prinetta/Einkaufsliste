package de.moco.gelin.view.gelincomposable


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@Composable
fun GroceryEntryItem(categoryColorId: Int){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        elevation = 10.dp
    ) {
        Row (
            modifier = Modifier
                .background(colorResource(id = categoryColorId)),
            verticalAlignment = Alignment.CenterVertically
        ){
            BoughtCheckbox()
            SpacerHorizontalXS()
            //Hier kommt die Zahl aus der Datenbank üebr die Menge an
            Fliesstext(name = "[Z]")
            SpacerHorizontalXS()
            //Hier kommt die Einheit aus der Datenbank hin
            Fliesstext(name = "[Einheit]")
            SpacerHorizontalXS()
            //Hier kommt die Ware aus der Datenbank hin
            Fliesstext(name = "[Lebensmittel]")
        }
    }

}


@Composable
fun BoughtCheckbox() {
    val checkedState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
}
