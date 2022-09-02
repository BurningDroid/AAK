package dev.aaron.aak.common

fun <T> failureOf(failedResult: Result<Any>): Result<T> =
    Result.failure(failedResult.exceptionOrNull() ?: Exception())