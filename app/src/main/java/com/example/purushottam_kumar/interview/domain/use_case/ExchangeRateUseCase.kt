package com.example.purushottam_kumar.interview.domain.use_case

import com.example.purushottam_kumar.interview.data.repository.ExchangeRateRepositoryImpl
import com.example.purushottam_kumar.interview.domain.Rate
import kotlinx.coroutines.flow.Flow

class ExchangeRateUseCase(private val repositoryImpl: ExchangeRateRepositoryImpl) {

    suspend fun getExchangeRate(baseCurrency : String) : Flow<List<Rate>>{
        return repositoryImpl.getExchangeRate(baseCurrency)
    }
}