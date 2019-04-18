package com.example.vendingmachine.valueobject.drink

import vendingmachine.valueobject.drink.Amount
import vendingmachine.valueobject.drink.Price
import vendingmachine.valueobject.drink.Size
import vendingmachine.valueobject.drink.Status

class Drink(
    override val status: Status,
    override val name: Name,
    override val price: Price,
    override val amount: Amount,
    override val size: Size,
    override val type:Type
):IDrink {

}