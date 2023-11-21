package com.example.practical_work_10

class Converter {
    fun fromDecimalToBinary(decimal: Int): String? {
        return decimal.toString(2).ifEmpty { null }
    }

    fun fromDecimalToOctal(decimal: Int): String? {
        return decimal.toString(8).ifEmpty { null }
    }

    fun fromDecimalToHexadecimal(decimal: Int): String? {
        return decimal.toString(16).ifEmpty { null }
    }
}