package com.example.vendingmachine.valueobject.money

class Frog(value: String):IMoney {
    override val valueArrayList: MutableList<Int> = mutableListOf(1,2)
    //カエルを自販機の投入口に入れたときのエラーメッセージ
}