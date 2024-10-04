package com.example.purushottam_kumar.interview.data.repository

import com.example.purushottam_kumar.interview.data.mapper.toRate
import com.example.purushottam_kumar.interview.data.remote.RatesService
import com.example.purushottam_kumar.interview.domain.Rate
import com.example.purushottam_kumar.interview.presentation.repository.ExchangeRateRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ExchangeRateRepositoryImpl(private val ratesService: RatesService) : ExchangeRateRepository {


    override suspend fun getExchangeRate(baseCurrency: String): Flow<List<Rate>> = flow {
        try {
            val response = ratesService.getRates(baseCurrency)
            if (response != null) {
                val rate = response.map {
                    it.toRate()
                }
                emit(rate)
            } else {
                // Handle the case where response is null (e.g., log an error or handle accordingly)
            }
        } catch (e: Exception) {
            // Handle exceptions here (e.g., log an error or handle accordingly)
        }

    }.flowOn(Dispatchers.IO)
}