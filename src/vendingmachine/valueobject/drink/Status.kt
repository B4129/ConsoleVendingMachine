package vendingmachine.valueobject.drink


class Status(
    // TODO: 2019/04/17 Sakai_Yuji HOT/COOLを持たせたい
    private val temperature:String
) {
    init {
        require(temperature == "HOT" || temperature == "COOL" ){"温度異常"}
    }
}