package com.example.purushottam_kumar.interview.data.mapper

import com.example.purushottam_kumar.interview.data.RateDto
import com.example.purushottam_kumar.interview.domain.Rate
import java.util.*

fun RateDto.toRate() : Rate {
    val formattedVale = String.format(Locale.getDefault(), "%,.2f", value)
    return Rate(currency, formattedVale)
}