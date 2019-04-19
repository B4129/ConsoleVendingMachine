package vendingmachine.valueobject.money

class Bills(
    val billList: MutableMap<Int, Int> = mutableMapOf(
        1000 to 0,
        5000 to 0,
        10000 to 0
    )
)