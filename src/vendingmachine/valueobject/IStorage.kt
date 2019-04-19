package com.example.vendingmachine.valueobject.money

import vendingmachine.valueobject.money.Bills
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.money.Coins

interface IStorage {
    val coins: Coins
    val bills: Bills
    fun sumValue(): Int
}
