package de.moco.gelin.view.gelinComposable.Dataclasses


import de.moco.gelin.R

sealed class NavDrawerItem(var route: String, var name: String, var beschreibung: String, var icon: Int ) {
    object Einkaufsliste : NavDrawerItem(
        EINKAUFSLISTE,
        EINKAUFSLISTE,
        EINKAUFSLISTEBESCHREIBUNG,
        R.drawable.ic_einkaufswagen)

    object Angebote :
        NavDrawerItem(ANGEBOTE,
            ANGEBOTE,
            ANGEBOTEBESCHREIBUNG,
            R.drawable.ic_vector_24)

    object WoIstDerNaechsteSupermarkt : NavDrawerItem(WOISTDERNAECHTESUPERMARKT,
        WOISTDERNAECHTESUPERMARKT,
        WOISTDERNAECHTESUPERMARKTBESCHREIBUNG,
        R.drawable.ic_region)

    object Haushaltsbuch : NavDrawerItem(HAUSHALTSBUCH,
        HAUSHALTSBUCH,
        HAUSHALTSBUCHBESCHREIBUNG,
        R.drawable.ic_haushaltsbuch_24)

    object MeinProfil : NavDrawerItem(MEINPROFIL,
        MEINPROFIL,
        MEINPROFILBESCHREIBUNG,
        R.drawable.ic_person_white)

    object Einstellungen :
        NavDrawerItem(EINSTELLUNGEN,
            EINSTELLUNGEN,
            EINSTELLUNGENBESCHREIBUNG,
            R.drawable.ic_settings)

    object Login :
        NavDrawerItem(LOGIN,
            LOGIN, LOGINBESCHREIBUNG,
            R.drawable.ic_person_white)

    object Registrieren :
        NavDrawerItem(REGISTIERUNG,
            REGISTIERUNG,
            REGISTRERUNGSBESCHREIBUNG,
            R.drawable.ic_person_white)
}