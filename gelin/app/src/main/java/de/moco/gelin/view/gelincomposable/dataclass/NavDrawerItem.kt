package de.moco.gelin.view.gelincomposable.dataclass

import de.moco.gelin.R

sealed class NavDrawerItem(var route: String, var name: String, var beschreibung: String, var icon: Int ) {
    object GroceryList : NavDrawerItem(
        EINKAUFSLISTE,
        EINKAUFSLISTE,
        EINKAUFSLISTEBESCHREIBUNG,
        R.drawable.ic_einkaufswagen)

    object Offers :
        NavDrawerItem(
            ANGEBOTE,
            ANGEBOTE,
            ANGEBOTEBESCHREIBUNG,
            R.drawable.ic_vector_24)

    object NextGroceryStore : NavDrawerItem(
        WOISTDERNAECHTESUPERMARKT,
        WOISTDERNAECHTESUPERMARKT,
        WOISTDERNAECHTESUPERMARKTBESCHREIBUNG,
        R.drawable.ic_region)

    object Bookkeeping : NavDrawerItem(
        HAUSHALTSBUCH,
        HAUSHALTSBUCH,
        HAUSHALTSBUCHBESCHREIBUNG,
        R.drawable.ic_haushaltsbuch_24)

    object UserProfile : NavDrawerItem(
        MEINPROFIL,
        MEINPROFIL,
        MEINPROFILBESCHREIBUNG,
        R.drawable.ic_person_white)

    object Settings :
        NavDrawerItem(
            EINSTELLUNGEN,
            EINSTELLUNGEN,
            EINSTELLUNGENBESCHREIBUNG,
            R.drawable.ic_settings)

    object Login :
        NavDrawerItem(
            LOGIN,
            LOGIN, LOGINBESCHREIBUNG,
            R.drawable.ic_person_white)

    object Registration :
        NavDrawerItem(
            REGISTIERUNG,
            REGISTIERUNG,
            REGISTRERUNGSBESCHREIBUNG,
            R.drawable.ic_person_white)
}