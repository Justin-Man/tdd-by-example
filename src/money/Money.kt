package money

open class Money(val amount: Int, protected open val currency: String) : Expression {

    override fun plus(addend: Expression): Expression = Sum(this, addend)

    override fun times(multiplier: Int): Expression = Money(amount * multiplier, currency)

    fun currency() = currency

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount && currency() == money.currency()
    }

    override fun toString() = "$amount $currency"

    override fun reduce(bank: Bank, to: String) : Money {
        // ask the bank for the right rate
        val rate = bank.rate(currency, to)

        return Money(amount / rate, to)
    }

    companion object {
        fun dollar(amount: Int) = Money(amount, "USD")
        fun franc(amount: Int) = Money(amount, "CHF")
    }
}