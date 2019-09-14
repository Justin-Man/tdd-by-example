package money

class Franc(amount: Int, override val currency: String) : Money(amount, currency) {
}