package de.moco.gelin.view.gelinComposable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.moco.gelin.R
import de.moco.gelin.view.*
import de.moco.gelin.view.gelinComposable.Dataclasses.HAUSHALTSBUCH_DETAIL
import de.moco.gelin.view.gelinComposable.Dataclasses.NavDrawerItem
import de.moco.gelin.view.gelinComposable.Dataclasses.PRODUKTHINZUFUEGEN
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import androidx.compose.material.Icon as Icon1

class Topbar : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        }
    }
}

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar(scope = scope, scaffoldState = scaffoldState) },
        drawerBackgroundColor = colorResource(id = R.color.darkgreen),
        drawerContent = {
            Drawer(scope = scope, scaffoldState = scaffoldState, navController = navController)
        },
        backgroundColor = colorResource(id = R.color.white)
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Navigation(navController = navController)
        }
    }
    // }
}


@Composable
fun TopBar(scope: CoroutineScope, scaffoldState: ScaffoldState) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
        navigationIcon = {
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                Icon1(Icons.Filled.Menu, "Menu")
            }
        },
        backgroundColor = colorResource(id = R.color.darkgreen),
        contentColor = colorResource(id = R.color.white)
    )
}


@Composable
fun Drawer(scope: CoroutineScope, scaffoldState: ScaffoldState, navController: NavController) {
    val items = listOf(
        NavDrawerItem.Einkaufsliste,
        NavDrawerItem.Angebote,
        NavDrawerItem.WoIstDerNaechsteSupermarkt,
        NavDrawerItem.Haushaltsbuch,
        NavDrawerItem.MeinProfil,
        NavDrawerItem.Einstellungen,
        NavDrawerItem.Login,
        NavDrawerItem.Registrieren
    )
    Column {
        // Header
        Image(
            painter = painterResource(id = R.drawable.logo_gelin),
            contentDescription = R.drawable.logo_gelin.toString(),
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(10.dp)
        )
        // Space between
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )
        // List of navigation items
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            DrawerItem(item = item, selected = currentRoute == item.route, onItemClick = {
                navController.navigate(item.route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Developed by Gelin Studios",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}


@Composable
fun DrawerItem(item: NavDrawerItem, selected: Boolean, onItemClick: (NavDrawerItem) -> Unit) {
    val background = if (selected) R.color.brightgreen else android.R.color.transparent
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(colorResource(id = background))
            .padding(start = 10.dp)
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.beschreibung.toString(),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(text = item.name, fontSize = 16.sp, color = Color.White)
        //FliesstextString(name = item.name)
    }
}


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavDrawerItem.Einkaufsliste.route) {
        composable(NavDrawerItem.Einkaufsliste.route) {
            EinkaufslisteView(navController)
        }
        composable(NavDrawerItem.Angebote.route) {
            Angebotsseite()
        }
        composable(NavDrawerItem.WoIstDerNaechsteSupermarkt.route) {
            LebensmittelHinzufuegenManuell()
        }
        composable(NavDrawerItem.Haushaltsbuch.route) {
            BookkeepingView(navController)
        }
        composable(NavDrawerItem.MeinProfil.route) {
            UserProfil()
        }
        composable(NavDrawerItem.Einstellungen.route) {
            AddingProductsUseingScanner()
        }
        composable(NavDrawerItem.Login.route) {
            LoginView()
        }
        composable(NavDrawerItem.Registrieren.route) {
            RegistrierungsView()
        }
        composable(PRODUKTHINZUFUEGEN) { LebensmittelHinzufuegenManuell() }
        composable(HAUSHALTSBUCH_DETAIL) { BookkeepingDetailView() }
    }
}
