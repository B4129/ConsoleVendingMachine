package com.example.vendingmachine.valueobject

import com.example.vendingmachine.valueobject.drink.*
import com.example.vendingmachine.valueobject.money.Storage

class Rack {
    val storage = Storage()
    val drinks = mutableListOf(
        Triple(1, 1, Drink(Status("HOT"), Name("コカコーラ"), Price(160), Amount(5), Size(350), Type("PET"))),
        Triple(1, 2, Drink(Status("COOL"), Name("牛乳"), Price(130), Amount(8), Size(500), Type("CAN"))),
        Triple(2, 1, Drink(Status("COOL"), Name("リアルゴールド"), Price(130), Amount(2), Size(500), Type("PET"))),
        Triple(2, 2, Drink(Status("COOL"), Name("抹茶"), Price(160), Amount(0), Size(350), Type("CAN")))
    )
}