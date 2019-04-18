package com.example.vendingmachine.valueobject.money


interface IMoney {
    val valueArrayList: MutableList<Int>
    val yen:Int
    fun countMoney(money:IMoney)
    fun toInt():Int
}
