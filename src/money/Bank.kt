package money

import java.util.*
import kotlin.Pair

class Bank {

    private val rates = Hashtable<kotlin.Pair<String, String>, Int>()

    fun reduce(source: Expression, to: String) : Money {
        return source.reduce(this, to)
    }

    fun rate(from: String, to: String) : Int {
       return rates[Pair(from, to)]?.let {
           it
       }!!
    }

    fun addRate(from: String, to: String, rate: Int) {
        rates[kotlin.Pair(from, to)] = rate
    }
}