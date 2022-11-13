package de.mocows.gelin

import DrawerBody
import DrawerHeader
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import de.mocows.gelin.ui.userinterface.ui.theme.NavigationDrawerComposeTheme
import de.mocows.gelin.view.MainScreen
import de.mocows.gelin.view.gelinView.AppBar
import de.mocows.gelin.view.gelinView.Dataclasses.MenuItem
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}








