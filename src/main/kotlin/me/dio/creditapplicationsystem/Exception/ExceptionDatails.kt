package me.dio.creditapplicationsystem.Exception

import java.time.LocalDateTime

data class ExceptionDatails(
    val title: String,
    val timestamp: LocalDateTime,
    val status: Int,
    val exeception: String,
    val datails: MutableMap<String, String?>
) {
}