package com.example.vendingmachine.valueobject.money

class Bill(value: Int):IMoney {
    override val valueArrayList:MutableList<Int> = mutableListOf(1000,5000,10000)
    init {
        if (value !in valueArrayList) throw IllegalArgumentException()
    }
}