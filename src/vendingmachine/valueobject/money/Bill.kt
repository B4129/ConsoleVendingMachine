package com.example.vendingmachine.valueobject.money

class Bill(value: Int):IMoney {

    override val valueArrayList:MutableList<Int> = mutableListOf(1000,5000,10000)
    override val yen:Int = value
    init {
        //if (value !in valueArrayList) throw IllegalArgumentException()
    }


    override fun toInt(): Int {
        return yen
    }
}