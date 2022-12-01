package de.mocows.gelin.model.purchaseentry

import java.time.LocalDate

class PurchaseEntry(private val date: LocalDate,
                    private val priceInCents: Int,
                    private val groceryStore: String,
                    private val address: String,
                    private val description: String? = null,
                    private val receiptImage: String? = null)