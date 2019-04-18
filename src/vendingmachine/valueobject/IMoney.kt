package com.example.vendingmachine.valueobject.money


interface IMoney {
    val valueArrayList: MutableList<Int>
    val yen:Int
    fun toInt():Int
}
