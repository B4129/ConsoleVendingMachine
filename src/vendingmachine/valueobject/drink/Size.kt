package com.example.vendingmachine.valueobject.drink



class Size(private val value: Int) {

    init {
        require(value != 350 or 500) {"サイズ異常"}
    }
}