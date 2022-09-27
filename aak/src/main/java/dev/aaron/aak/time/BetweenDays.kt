package dev.aaron.aak.time

import java.time.Duration
import java.time.LocalDateTime
import java.util.*

fun betweenDays(
    from: Long,
    to: Long? = null
): Long {
    val toDateTime = if (to == null) LocalDateTime.now() else getLocalDate(to)
    return Duration.between(getLocalDate(from), toDateTime).toDays()
}

private fun getLocalDate(dateTime: Long): LocalDateTime {
    val cal = Calendar.getInstance().apply { timeInMillis = dateTime }
    val year = cal.get(Calendar.YEAR)
    val month = cal.get(Calendar.MONTH) + 1
    val day = cal.get(Calendar.DAY_OF_MONTH)
    return LocalDateTime.of(year, month, day, 0, 0)
}