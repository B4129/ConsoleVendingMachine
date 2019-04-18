package com.example.vendingmachine.valueobject.money

interface IStorage {
    val coins: MutableList<Pair<Coin, Int>>
    val bills: MutableList<Pair<Bill, Int>>
}
