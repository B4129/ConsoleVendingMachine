package com.example.vendingmachine.valueobject

import com.example.vendingmachine.valueobject.drink.*
import vendingmachine.valueobject.drink.*
import vendingmachine.valueobject.wallet.Storage

class Rack {
    val storage = Storage()
    private val makedrink1 = Drink(Status("HOT"), Name("コカコーラ"), Price(160), Amount(5), Size(350), Type("PET"))
    private val makedrink2 = Drink(Status("COOL"), Name("牛乳"), Price(130), Amount(8), Size(500), Type("CAN"))
    private val makedrink3 = Drink(Status("COOL"), Name("リアルゴールド"), Price(130), Amount(2), Size(500), Type("PET"))
    private val makedrink4 = Drink(Status("COOL"), Name("抹茶"), Price(160), Amount(0), Size(350), Type("CAN"))

    val drinks = mutableListOf(
        Triple(1, 1, makedrink1),
        Triple(1, 2, makedrink2),
        Triple(2, 1, makedrink3),
        Triple(2, 2, makedrink4)
    )

}
