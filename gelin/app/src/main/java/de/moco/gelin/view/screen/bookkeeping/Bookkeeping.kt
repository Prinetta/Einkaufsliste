package de.moco.gelin.view.screen

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
import androidx.navigation.NavHostController
import de.moco.gelin.R
import de.moco.gelin.view.gelincomposable.*
import de.moco.gelin.view.gelincomposable.dataclass.HAUSHALTSBUCH_DETAIL
import de.moco.gelin.view.gelincomposable.dataclass.NavDrawerItem

@Composable
fun BookkeepingView(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SpacerVerticalXS()
        Ueberschrift1(name = stringResource(id = R.string.haushaltsbuch))
        Column {
            BookkeepingItem(navController)
            BookkeepingItem(navController)
            BookkeepingItem(navController)
        }
    }
}

@Composable
fun BookkeepingItem(navController: NavHostController) {
    Card(modifier = Modifier
        .padding(vertical = 5.dp)
        .fillMaxWidth()
        .clickable {
            navController.navigate(HAUSHALTSBUCH_DETAIL){
                popUpTo(NavDrawerItem.Bookkeeping.route)
            }
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
            Column {
                Ueberschrift3("Einkauf: DD.MM.JJJJ")
                Fliesstext("[XX,00] €")
                BookkeepingStoreAddress()
            }
        }
    }
}

@Composable
fun BookkeepingStoreAddress(){
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

@Composable
fun BookkeepingDetailView() {
    Column {
        Box(
            Modifier
            .fillMaxWidth()
            .size(170.dp)
            .clip(RectangleShape)
            .background(Color.LightGray)
        )
        Column(Modifier.padding(horizontal = 15.dp)) {
            Ueberschrift1(stringResource(R.string.haushaltsbuch))
            SpacerVerticalXS()
            Row {
                BookkeepingStoreAddress()
                Spacer(Modifier.weight(1f))
                Ueberschrift2("[XX,00] €")
            }
            SpacerVerticalXS()
            Fliesstext("[Description]")
        }
    }
}