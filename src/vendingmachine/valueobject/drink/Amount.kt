package vendingmachine.valueobject.drink


class Amount(amount: Int) {
    init {
        require(amount >= 0) { "在庫数が異常です" }
    }
    val value = amount
}