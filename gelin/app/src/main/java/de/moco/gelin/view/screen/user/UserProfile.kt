package de.moco.gelin.view.screen

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
import de.moco.gelin.R
import de.moco.gelin.view.gelincomposable.BackgroundPic
import de.moco.gelin.view.gelincomposable.SpacerHorizontalM
import de.moco.gelin.view.gelincomposable.Ueberschrift3
import de.moco.gelin.view.gelincomposable.dataclass.*


@Composable
fun UserProfileView() {
    BackgroundPic()
     Column(
         modifier = Modifier
             .fillMaxWidth()
             .fillMaxHeight()
             ) {
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
fun UserProfilePreview(){
    UserProfileView()
}




