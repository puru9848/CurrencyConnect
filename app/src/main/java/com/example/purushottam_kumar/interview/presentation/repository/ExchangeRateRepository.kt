package com.example.purushottam_kumar.interview.presentation.repository

import com.example.purushottam_kumar.interview.domain.Rate
import kotlinx.coroutines.flow.Flow

interface ExchangeRateRepository {

    suspend fun getExchangeRate(baseCurrency : String) : Flow<List<Rate>>
}

