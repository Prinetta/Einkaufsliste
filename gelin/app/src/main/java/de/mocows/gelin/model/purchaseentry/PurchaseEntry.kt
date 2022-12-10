package de.mocows.gelin.model.purchaseentry

import java.time.LocalDate

data class PurchaseEntry(val date: LocalDate,
                    val priceInCents: Int,
                    val groceryStore: String,
                    val address: String,
                    val description: String? = null,
                    val receiptImage: String? = null)