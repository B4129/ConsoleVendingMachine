package com.example.vendingmachine.valueobject.money

class Coin(value: Int) : IMoney {
    val yen:Int = value
    override val valueArrayList: MutableList<Int> = mutableListOf(5, 10, 50, 100, 500)

    init {

        //if (value !in valueArrayList) throw IllegalArgumentException()
    }


    fun toInt(): Int {
        return yen
    }

}

