package com.etisalattask.movies.common.presentation.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale


fun formatDateString(dateString: String?): String {
    return try {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH)
        val date = LocalDate.parse(dateString, inputFormatter)
        date.format(outputFormatter)
    } catch (e: Exception) {
        "N/A"
    }
}