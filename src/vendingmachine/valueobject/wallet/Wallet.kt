package com.example.vendingmachine.valueobject.money

import vendingmachine.valueobject.money.Coin


class Wallet(
    override val coins: MutableMap<Coin, Int> = mutableMapOf(
        Coin(10) to 0,
        Coin(50) to 0,
        Coin(100) to 0,
        Coin(500) to 0
    ),
    override val bills:  MutableMap<Bill, Int> = mutableMapOf(
        Bill(1000) to 0,
        Bill(5000) to 0,
        Bill(10000) to 0
    )

) : IStorage {
    override fun sumValue(): Int {
        var sum = 0
        coins.forEach { coin, value -> sum += coin.yen * value }
        bills.forEach { bill, value -> sum += bill.yen * value }
        return sum
    }
}