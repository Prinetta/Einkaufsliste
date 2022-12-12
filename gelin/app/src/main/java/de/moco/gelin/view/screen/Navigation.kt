package de.moco.gelin.view.gelincomposable

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.moco.gelin.view.gelincomposable.dataclass.HAUSHALTSBUCH_DETAIL
import de.moco.gelin.view.gelincomposable.dataclass.NavDrawerItem
import de.moco.gelin.view.gelincomposable.dataclass.PRODUKTHINZUFUEGEN
import de.moco.gelin.view.screen.*
import de.moco.gelin.view.screen.addgroceryentry.AddGroceryEntryUsingScannerView
import de.moco.gelin.view.screen.grocerylist.GroceryListView
import de.moco.gelin.view.screen.map.NextGroceryStoreMap
import de.moco.gelin.view.screen.registration.RegistrationView


@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavDrawerItem.GroceryList.route) {
        composable(NavDrawerItem.GroceryList.route) {
            GroceryListView(navController)
        }
        composable(NavDrawerItem.Offers.route) {
            OfferView()
        }
        composable(NavDrawerItem.NextGroceryStore.route) {
            NextGroceryStoreMap()
        }
        composable(NavDrawerItem.Bookkeeping.route) {
            BookkeepingView(navController)
        }
        composable(NavDrawerItem.UserProfile.route) {
            UserProfileView()
        }
        composable(NavDrawerItem.Settings.route) {
            AddGroceryEntryUsingScannerView()
        }
        composable(NavDrawerItem.Login.route) {
            LoginView()
        }
        composable(NavDrawerItem.Registration.route) {
            RegistrationView()
        }
        composable(PRODUKTHINZUFUEGEN) { AddGroceryEntryView() }
        composable(HAUSHALTSBUCH_DETAIL) { BookkeepingDetailView() }
    }
}