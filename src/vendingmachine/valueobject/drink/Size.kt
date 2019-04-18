package com.example.vendingmachine.valueobject.drink

import java.lang.IllegalArgumentException

class Size(private val value: Int) {

    init {
        if (value != 350 or 500) throw IllegalArgumentException("サイズ異常")
    }
}