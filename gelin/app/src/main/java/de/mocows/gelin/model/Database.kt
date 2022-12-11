package de.mocows.gelin.model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

val database: FirebaseDatabase = FirebaseDatabase.getInstance()
val databaseRef: DatabaseReference = database.reference