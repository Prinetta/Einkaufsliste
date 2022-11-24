package de.mocows.gelin.view

import android.icu.lang.UCharacter.VerticalOrientation
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import de.mocows.gelin.ui.userinterface.ui.theme.brightgreen
import de.mocows.gelin.view.gelinComposable.*
import de.mocows.gelin.view.gelinComposable.Dataclasses.*

@Composable
fun UserProfil( ) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)) {
        Row(horizontalArrangement = Arrangement.Center) {
            Image(painter = painterResource(id = R.drawable.ic_person_grey),
            contentDescription = PROFILBILD)
        }
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
            Image(painter = painterResource(id = R.drawable.ic_pencil_36),
                contentDescription = "bearbeiten",
                modifier = Modifier.clickable { })
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.Start) {
            Text(text = USERBEISPIELNAME)
            Text(text = VOLLRECHTE)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.Start) {
            Text(text = USERBEISPIELNAME)
            Text(text = VOLLRECHTE)
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp), Arrangement.Start) {
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
    }
}

@Preview
@Composable
fun UserProfilPreview(){
    UserProfil()
}

fun onClick(function: () -> Unit) {
    TODO("Not yet implemented")
}



