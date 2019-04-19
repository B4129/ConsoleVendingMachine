package vendingmachine.valueobject.drink


class Price(private val price: Int) {
    init {
        require(price % 10 == 0) { "金額が不正です" }
    }
    val value = price

}
