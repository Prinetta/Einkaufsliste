package de.mocows.gelin.view.gelinComposable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat.MessagingStyle.Message
import de.mocows.gelin.view.gelinComposable.Dataclasses.NavDrawerItem


@Composable
fun Angebotsseite(message: List<Message>){
    Ueberschrift1(name = "Angebot der Wochee")
    ProduktAnzeigeAngebot()
    

}