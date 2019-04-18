package com.example.vendingmachine.valueobject.drink

import java.lang.IllegalArgumentException

class Price(price: Int) {
    init {
        if (price % 10 != 0) throw IllegalArgumentException("金額が不正です")
    }
}