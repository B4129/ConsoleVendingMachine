package com.example.vendingmachine.valueobject.drink

interface IDrink {
    val status: Status
    val name: Name
    val price: Price
    val amount: Amount
    val size: Size
    val type:Type
}