package it.garrik.howtobuildandroidappswithkotlin

import java.math.BigInteger

class NumberAdder {
    @Throws(InvalidNumberException::class)
    fun sum(n: Int, callback: (BigInteger) -> Unit) {
        if (n < 0) {
            throw InvalidNumberException
        }
        callback(n.toBigInteger().times((n.toBigInteger() + 1.toBigInteger())).divide(2.toBigInteger()))
    }
    object InvalidNumberException : Throwable()
}