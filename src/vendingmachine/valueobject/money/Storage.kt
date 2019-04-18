package com.example.vendingmachine.valueobject.money


class Storage(
    override val coins: MutableList<Pair<Coin, Int>> = mutableListOf(
        Pair(Coin(10), 0),
        Pair(Coin(50), 0),
        Pair(Coin(100), 0),
        Pair(Coin(500), 0)
    ),
    override val bills: MutableList<Pair<Bill, Int>> = mutableListOf(
        Pair(Bill(1000), 0),
        Pair(Bill(5000), 0),
        Pair(Bill(10000), 0)
    )
) : IStorage