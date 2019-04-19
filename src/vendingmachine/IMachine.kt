package com.example.vendingmachine.machine


interface IMachine {
    val calculator:Calculator
    fun onButtonLight()
    fun offButtonLight()
    fun onButtonClick()
}
