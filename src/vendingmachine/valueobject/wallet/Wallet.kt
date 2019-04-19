package com.example.vendingmachine.valueobject.money

import vendingmachine.valueobject.money.Bills
import vendingmachine.valueobject.money.Coins


class Wallet(
    override val coins: Coins = Coins(),
    override val bills: Bills = Bills()

) : IStorage {
    private var sum: Int = 0
    override fun sumValue(): Int {
         sum = 0
        coins.coinList.forEach { coin -> sum += coin.key * coin.value }
        bills.billList.forEach { bill -> sum += bill.key * bill.value }
        return sum
    }
}