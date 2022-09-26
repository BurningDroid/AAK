package dev.aaron.aak.number

import kotlin.math.pow
import kotlin.math.round

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