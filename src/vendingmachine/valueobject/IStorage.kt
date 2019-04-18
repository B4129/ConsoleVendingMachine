package com.example.vendingmachine.valueobject.money

interface IStorage {
    val coins: MutableMap<Coin, Int>
    val bills: MutableMap<Bill, Int>
    fun sum(): Int
}
