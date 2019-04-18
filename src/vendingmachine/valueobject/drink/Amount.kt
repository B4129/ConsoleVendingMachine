package com.example.vendingmachine.valueobject.drink

class Amount(value: Int) {
    init {
        if (value < 0) throw IllegalArgumentException("在庫数が異常です")
    }
}