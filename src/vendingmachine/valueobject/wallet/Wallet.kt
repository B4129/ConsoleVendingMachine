package com.example.vendingmachine.valueobject.money

import vendingmachine.valueobject.money.Bills
import vendingmachine.valueobject.money.Coins


class Wallet(
    override val coinl: Coins = Coins(),
    override val billl: Bills = Bills()

) : IStorage {
    private var sum: Int = 0
    override fun sumValue(): Int {
        var coins = coinl
        var bills = billl
         sum = 0
        coinl.coinList.forEach { coin -> sum += coin.key.toInt() * coin.value }
        billl.billList.forEach { bill -> sum += bill.key.toInt() * bill.value }
        return sum
    }
}