package vendingmachine.valueobject.drink


class Price(price: Int) {
    init {
        require(price % 10 == 0) { "金額が不正です" }
    }
}