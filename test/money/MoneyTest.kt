package money

import org.junit.Assert.*
import org.junit.Test

class MoneyTest {

    @Test
    fun testMultiplication() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testFrancMultiplication() {
        val five = Money.franc(5)
        assertEquals(Money.franc(10), five.times(2))
        assertEquals(Money.franc(15), five.times(3))
    }

    @Test
    fun testEquality() {
        assertTrue(Money.dollar(5) == Money.dollar(5))
        assertFalse(Money.dollar(5) == Money.dollar(6))
        assertFalse(Money.franc(5).equals(Money.dollar(5)) )
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum = five.plus(five)
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")

        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun testPlusReturnSum() {
        val five = Money.dollar(5)
        val result = five.plus(five)
        val sum = result as Sum

        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }

    @Test
    fun testReduceSum() {
        val sum = Sum(Money.dollar(3), Money.dollar(4))
        val bank = Bank()

        val result = bank.reduce(sum, "USD")

        assertEquals(Money.dollar(7), result)
    }

    @Test
    fun testReduceMoney() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}