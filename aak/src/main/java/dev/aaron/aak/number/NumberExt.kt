package dev.aaron.aak.number

fun String?.toSafeInt(default: Int = 0) = this?.trim()?.toIntOrNull() ?: default

fun String?.toSafeFloat(default: Float = 0F) = this?.trim()?.toFloatOrNull() ?: default

fun String?.toSafeDouble(default: Double = 0.0) = this?.trim()?.toDoubleOrNull() ?: default