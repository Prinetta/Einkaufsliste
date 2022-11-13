package de.mocows.gelin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import de.mocows.gelin.R
import de.mocows.gelin.view.gelinComposable.*

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login()
        }
    }

    @Composable
    fun Login(){
        LogoImage()
        CardViewLogin()
    }

    @Composable
    fun CardViewLogin() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Ueberschrift1(name = R.string.login)
                Fliesstext(name = R.string.begrueßungsTextLogin)
                ImputFieldOhneEingabeText(name = "Usename")
                ImputFieldMitEingabeText(name = "Passwort: ")
                Button()
            }
        }
    }

    @Composable
    fun Button() {
        androidx.compose.material.Button(onClick = { /* Do something! */ },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Green
            ),
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Fliesstext(name = R.string.login)
        }
    }


}




