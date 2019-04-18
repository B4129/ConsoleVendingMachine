package vendingmachine.valueobject.drink



class Size(value: Int = 350)  {

    init {
        require(value == 350 || value == 500) {"サイズ異常"}
    }
}