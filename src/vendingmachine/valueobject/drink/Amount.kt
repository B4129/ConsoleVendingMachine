package vendingmachine.valueobject.drink


class Amount(value: Int) {
    init {
        require(value < 0) { "在庫数が異常です" }
    }
}