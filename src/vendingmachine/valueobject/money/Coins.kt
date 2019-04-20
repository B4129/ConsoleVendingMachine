package vendingmachine.valueobject.money

class Coins(
    val coinList: MutableMap<String, Int> = mutableMapOf(
        "10" to 0,
        "50" to 0,
        "100" to 0,
        "500" to 0
    )
){
    var list = coinList
}