package money

import java.util.*


class Bank {

    private val rates = Hashtable<Pair, Int>()

    fun reduce(source: Expression, to: String) : Money {
        return source.reduce(this, to)
    }

    fun rate(from: String, to: String): Int {

        if (from == to) return 1
        else return rates[Pair(from, to)]?.let { it }
            ?: 1 // if the rate does not exist
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates[Pair(from, to)] = rate
    }
}