package money

open class Money(protected val amount: Int, protected open val currency: String) {

    fun times(multiplier: Int) = Money(amount * multiplier, currency)

    fun currency() = currency

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount && currency() == money.currency()
    }

    override fun toString(): String {
        return "$amount $currency"
    }

    companion object {
        fun dollar(amount: Int) = Dollar(amount, "USD") as Money
        fun franc(amount: Int) = Franc(amount, "CHF") as Money
    }
}