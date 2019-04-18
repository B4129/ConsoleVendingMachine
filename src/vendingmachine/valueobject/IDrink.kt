package com.example.vendingmachine.valueobject.drink

import vendingmachine.valueobject.drink.Amount
import vendingmachine.valueobject.drink.Price
import vendingmachine.valueobject.drink.Size
import vendingmachine.valueobject.drink.Status

interface IDrink {
    val status: Status
    val name: Name
    val price: Price
    val amount: Amount
    val size: Size
    val type:Type
}