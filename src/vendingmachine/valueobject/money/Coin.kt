package com.example.vendingmachine.valueobject.money

class Coin(value: Int) : IMoney {

    override val yen:Int = value
    override val valueArrayList: MutableList<Int> = mutableListOf(5, 10, 50, 100, 500)

    init {

        require(value !in valueArrayList){"存在しない硬貨です"}
    }


    override fun toInt(): Int {
        return yen
    }

}

