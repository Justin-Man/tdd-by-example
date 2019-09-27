package money

interface Expression {
    fun reduce(bank: Bank, to: String) : Money // let the bank care about exchange rates
    fun plus(addend: Expression): Expression?
    fun times(multiplier: Int): Expression
}