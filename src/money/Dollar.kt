package money

class Dollar(amount: Int, override val currency: String) : Money(amount, currency) {
}