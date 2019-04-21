package vendingmachine.valueobject.drink

import vendingmachine.valueobject.IDrink
import com.example.vendingmachine.valueobject.drink.Type

class Drink(
    override val status: Status,
    override val name: Name,
    override val price: Price,
    override val amount: Amount,
    override val size: Size,
    override val type: Type
): IDrink