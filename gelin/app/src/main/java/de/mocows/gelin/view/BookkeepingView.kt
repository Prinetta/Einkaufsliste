package de.mocows.gelin.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import de.mocows.gelin.view.gelinComposable.*

@Composable
fun BookkeepingView() {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SpacerVerticalXS()
        Ueberschrift1(name = stringResource(id = R.string.haushaltsbuch))
        Column {
            BookkeepingItem()
            BookkeepingItem()
            BookkeepingItem()
        }
    }
}

@Composable
fun BookkeepingItem() {
    Card(modifier = Modifier
        .padding(vertical = 5.dp)
        .fillMaxWidth()
        .clickable {

        },
        elevation = 10.dp){
        Row {
            Box( // TODO: rectangle -> replace with img of store or receipt
                modifier = Modifier
                    .size(84.dp)
                    .clip(RectangleShape)
                    .background(Color.LightGray)
            )
            SpacerHorizontalXS()
            BookkeepingStoreAddress()
        }
    }
}

@Composable
fun BookkeepingStoreAddress(){
    Column {
        Ueberschrift3("Einkauf: DD.MM.JJJJ")
        Fliesstext("[XX,00] €")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painterResource(id = R.drawable.ic_location_24),
                contentDescription ="Store Location",
                modifier = Modifier
                    .size(25.dp, 25.dp)
            )
            SpacerHorizontalXS()
            Column {
                Untertitel("[Supermarktname]")
                Untertitel("[Straße Hausnummer - 12345 Stadt]")
            }
        }
    }
}

@Composable
fun BookkeepingDetailView() {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RectangleShape)
                .background(Color.LightGray)
        )
        SpacerVerticalXS()
        Ueberschrift1(name = stringResource(id = R.string.haushaltsbuch))
        Column {
            BookkeepingItem()
            BookkeepingItem()
            BookkeepingItem()
        }
    }
}