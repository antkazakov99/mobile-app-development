package com.example.practicalwork8

import org.junit.Test

import org.junit.Assert.*

class UserNumConverterTest {

    @Test
    fun testFrom2To10()
    {
        val converter = UserNumConverter()
        assertEquals(5.0,converter.from2To10("101"))
        assertEquals(null,converter.from2To10("322"))
        assertEquals(null,converter.from2To10("test"))
    }

    @Test
    fun testFrom8To10()
    {
        val converter = UserNumConverter()
        assertEquals(65.0,converter.from8To10("101"))
        assertEquals(501.0,converter.from8To10("765"))
        assertEquals(null,converter.from8To10("test"))
        assertEquals(null,converter.from8To10("987"))
    }

    @Test
    fun testFrom16To10()
    {
        val converter = UserNumConverter()
        assertEquals(257.0,converter.from16To10("101"))
        assertEquals(169.0,converter.from16To10("A9"))
        assertEquals(15.0,converter.from16To10("F"))
        assertEquals(null,converter.from16To10("test"))
    }

}