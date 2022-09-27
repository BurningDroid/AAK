package dev.aaron.aak.time

import org.junit.Assert.assertEquals
import org.junit.Test

class BetweenDaysTest {
    @Test
    fun test() {
        val dateTime220926 = 1664118000000
        val dateTime220928 = 1664291252765
        assertEquals(2, betweenDays(dateTime220926, dateTime220928))
    }
}