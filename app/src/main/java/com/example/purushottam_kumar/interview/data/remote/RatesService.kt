package com.example.purushottam_kumar.interview.data.remote

import com.example.purushottam_kumar.interview.data.RateDto
import io.reactivex.Single

interface RatesService {
    suspend fun getRates(baseCurrencyCode: String): List<RateDto>
}

