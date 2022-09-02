package dev.aaron.aak.common

fun <T> failureOf(failedResult: Result<T>): Result<T> =
    Result.failure(failedResult.exceptionOrNull() ?: Exception())