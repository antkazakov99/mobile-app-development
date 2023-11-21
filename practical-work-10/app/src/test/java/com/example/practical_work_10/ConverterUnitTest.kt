package com.example.practical_work_10

import org.junit.Assert.assertEquals
import org.junit.Test

class ConverterUnitTest {
    @Test fun convertBinary_isCorrect() {
        val converter = Converter()
        assertEquals("1111111111111111111111111111111", converter.fromDecimalToBinary(Int.MAX_VALUE))
        assertEquals("-10000000000000000000000000000000", converter.fromDecimalToBinary(Int.MIN_VALUE))
        assertEquals("0", converter.fromDecimalToBinary(0))
        assertEquals("1111101000", converter.fromDecimalToBinary(1000))
    }
    @Test fun convertOctal_isCorrect() {
        val converter = Converter()
        assertEquals("17777777777", converter.fromDecimalToOctal(Int.MAX_VALUE))
        assertEquals("-20000000000", converter.fromDecimalToOctal(Int.MIN_VALUE))
        assertEquals("0", converter.fromDecimalToOctal(0))
        assertEquals("1750", converter.fromDecimalToOctal(1000))
    }
    @Test fun convertHex_isCorrect() {
        val converter = Converter()
        assertEquals("7fffffff", converter.fromDecimalToHexadecimal(Int.MAX_VALUE))
        assertEquals("-80000000", converter.fromDecimalToHexadecimal(Int.MIN_VALUE))
        assertEquals("0", converter.fromDecimalToHexadecimal(0))
        assertEquals("3e8", converter.fromDecimalToHexadecimal(1000))
    }
}