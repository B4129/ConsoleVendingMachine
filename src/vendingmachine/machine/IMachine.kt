package com.example.vendingmachine.machine

import com.example.vendingmachine.valueobject.money.IMoney


interface IMachine {
    fun receiveMoney(money: Any)
    fun outputMoney(): Int
    fun onButtonLight()
    fun offButtonLight()
    fun onButtonClick(buttonNumber: Int)
    fun insertMoney(money: Any)
    fun countMoney(money: Any)
}
