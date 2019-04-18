package com.example.vendingmachine.machine


interface IMachine {
    fun receiveMoney(money: Any)
    fun outputMoney(): Int
    fun onButtonLight()
    fun offButtonLight()
    fun onButtonClick(buttonNumber: Int)
    fun countMoney(money: Any)
    fun insertMoney(money: Any)
}
