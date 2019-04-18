package com.example.vendingmachine.valueobject.money

import vendingmachine.valueobject.money.Coin

interface IStorage {
    val coins: MutableMap<Coin, Int>
    val bills: MutableMap<Bill, Int>
    fun sumValue(): Int
}
