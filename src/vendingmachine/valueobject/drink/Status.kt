package com.example.vendingmachine.valueobject.drink


class Status(
    // TODO: 2019/04/17 Sakai_Yuji HOT/COOLを持たせたい
    private val temperature:String
) {
    init {
        //if(temperature != "HOT" && temperature != "COOL" )throw IllegalArgumentException("温度異常")
    }
}