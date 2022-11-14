package de.mocows.gelin.view.gelinComposable


import androidx.compose.ui.res.stringResource
import de.mocows.gelin.R
import de.mocows.gelin.R.string

sealed class NavDrawerItem(var route: String, var name: String, var beschreibung: String, var icon: Int ) {


    object Einkaufsliste : NavDrawerItem(
        "Einkaufsliste",
     "Einkaufsliste", "gehe zur Einkaufsliste",
        R.drawable.ic_einkaufswagen)

    object Angebote :
        NavDrawerItem("Angebote",
            "Angebote",
            "gehe zu Angebote",
            R.drawable.ic_vector_24)

    object WoIstDerNaechsteSupermarkt : NavDrawerItem("Wo ist der nächste Supermarkt?",
        "Wo ist der nächste Supermarkt?",
        "gehe zu wo ist der nächste Supermarkt?",
        R.drawable.ic_region)

    object Haushaltsbuch : NavDrawerItem("Haushaltsbuch",
        "Haushaltsbuch",
        "Gehe zum Haushaltsbuch",
        R.drawable.ic_haushaltsbuch_24)

    object MeinProfil : NavDrawerItem("mein Profil",
        "mein Profil",
        "gehe zu mein Profil",
        R.drawable.ic_person_white)

    object Einstellungen :
        NavDrawerItem("Einstellungen",
            "Einstellungen",
            "gehe zu Einstellungen",
            R.drawable.ic_settings)

    object Login :
        NavDrawerItem("login",
            "login","geheZuEinstellungen",
            R.drawable.ic_person_white)

    object Registrieren :
        NavDrawerItem("registrieren",
            "einstellungen",
            "gehe zu Einstellungen",
            R.drawable.ic_person_white)
}