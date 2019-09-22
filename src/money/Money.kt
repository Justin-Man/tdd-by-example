package money

open class Money(val amount: Int, protected open val currency: String) : Expression {

    fun times(multiplier: Int) = Money(amount * multiplier, currency)

    fun currency() = currency

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount && currency() == money.currency()
    }

    override fun toString() = "$amount $currency"

    fun plus(addend: Money) : Expression = Sum(this, addend)

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")
        fun franc(amount: Int) = Money(amount, "CHF")
    }
}