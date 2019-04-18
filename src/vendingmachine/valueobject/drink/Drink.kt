package com.example.vendingmachine.valueobject.drink

class Drink(
    override val status: Status,
    override val name: Name,
    override val price: Price,
    override val amount: Amount,
    override val size: Size,
    override val type:Type
):IDrink {

}