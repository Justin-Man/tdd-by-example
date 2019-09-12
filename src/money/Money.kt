package money

open class Money(internal val amount: Int) {
    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount && this.javaClass == money.javaClass
    }
}