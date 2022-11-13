package de.mocows.gelin.view


import de.mocows.gelin.R

sealed class NavDrawerItem(var route: String, var name: String, var beschreibung: Int, var icon: Int ) {

    object Einkaufsliste : NavDrawerItem(R.string.einkaufsliste.toString(),
        R.string.einkaufsliste.toString(),
        R.string.geheZurEinkaufsliste,
        R.drawable.ic_einkaufswagen)

    object Angebote :
        NavDrawerItem(R.string.angebote.toString(), R.string.angebote.toString(), R.string.geheZuAngebote, R.drawable.ic_vector_24)

    object WoIstDerNaechsteSupermarkt : NavDrawerItem(R.string.woIstDerNächsteSupermarkt.toString(),
        R.string.woIstDerNächsteSupermarkt.toString(),
        R.string.geheZuWoIstDerNächsteSupermarkt,
        R.drawable.ic_region)

    object Haushaltsbuch : NavDrawerItem(R.string.haushaltsbuch.toString(),
        R.string.haushaltsbuch.toString(),
        R.string.geheZuAngebote,
        R.drawable.ic_haushaltsbuch_24)

    object MeinProfil : NavDrawerItem(R.string.meinProfil.toString(),
        R.string.meinProfil.toString(),
        R.string.geheZuMeinProfil,
        R.drawable.ic_person_white)

    object Einstellungen :
        NavDrawerItem(R.string.einstellungen.toString(),
            R.string.einstellungen.toString(),
            R.string.geheZuEinstellungen,
            R.drawable.ic_settings)
}