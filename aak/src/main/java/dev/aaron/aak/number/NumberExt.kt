package dev.aaron.aak.number

import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.round

private val decimalFormat: DecimalFormat by lazy { DecimalFormat() }

fun String?.toSafeInt(default: Int = 0) = this?.trim()?.toIntOrNull() ?: default

fun String?.toSafeFloat(default: Float = 0F) = this?.trim()?.toFloatOrNull() ?: default

fun String?.toSafeDouble(default: Double = 0.0) = this?.trim()?.toDoubleOrNull() ?: default

fun Double.round(digit: Int = 2): Double {
    val v = 10F.pow(digit)
    return round(this * v) / v
}

fun Float.round(digit: Int = 2): Float {
    val v = 10F.pow(digit)
    return round(this * v) / v
}

fun Number?.toDollar(
    prefix: String = "$",
    default: String = "-",
    digit: Int = 2
): String {
    return if (this == null) {
        default
    } else {
        "${prefix}${decimalFormat.format(this.toFloat().round(digit))}"
    }
}