package com.example.vendingmachine.valueobject.money

import vendingmachine.valueobject.money.Bills
import vendingmachine.valueobject.money.Coin
import vendingmachine.valueobject.money.Coins

interface IStorage {
    val coinl: Coins
    val billl: Bills
    fun sumValue(): Int
}
