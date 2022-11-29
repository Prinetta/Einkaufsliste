package de.mocows.gelin.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import de.mocows.gelin.view.gelinComposable.*
import de.mocows.gelin.view.gelinComposable.Dataclasses.*

@Composable
fun UserProfil( ) {
     Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)) {
        SpacerHorizontalS()
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Ueberschrift3(name = UEBERDICH)
            Image(painter = painterResource(id = R.drawable.ic_pencil_36),
                contentDescription = "bearbeiten",
                modifier = Modifier.clickable { })
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween) {
            Text(text = NAME)
            Text(text = USERBEISPIELNAME)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween) {
            Text(text = PASSWORD)
            Text(text = PASSWORD)
        }
        SpacerHorizontalM()
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween) {
            Ueberschrift3(name = ZUGRIFSRECHT)
            StiftFuerBearbeiten(modifier = Modifier.clickable { })
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween) {
            Text(text = USERBEISPIELNAME)
            Text(text = VOLLRECHTE)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween) {
            Text(text = USERBEISPIELNAME)
            Text(text = VOLLRECHTE)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween) {
            Text(text = USERBEISPIELNAME)
            Text(text = VOLLRECHTE)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.SpaceBetween) {
            Ueberschrift3(name = UEBERDICH)
            Image(painter = painterResource(id = R.drawable.ic_pencil_36),
                contentDescription = "bearbeiten",
                modifier = Modifier.clickable { })
        }
         Row(modifier = Modifier
             .fillMaxWidth()
             .padding(5.dp), Arrangement.SpaceBetween) {
             Text(text = USERBEISPIELNAME)
             Text(text = VOLLRECHTE)
         }
    }
}

@Composable
fun StiftFuerBearbeiten(modifier: Modifier) {

}

@Preview
@Composable
fun UserProfilPreview(){
    UserProfil()
}




