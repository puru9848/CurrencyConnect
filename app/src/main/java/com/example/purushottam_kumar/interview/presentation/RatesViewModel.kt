package com.example.purushottam_kumar.interview.presentation

import androidx.lifecycle.*
import com.example.purushottam_kumar.interview.domain.Rate
import com.example.purushottam_kumar.interview.domain.use_case.ExchangeRateUseCase
import kotlinx.coroutines.launch

class RatesViewModel(private val exchangeRateUseCase: ExchangeRateUseCase) : ViewModel() {

    private val _rate = MutableLiveData<List<Rate>>()
    val rates: LiveData<List<Rate>> = _rate


    init {
        fetchExchangeRate()
    }

    private fun fetchExchangeRate() {
        viewModelScope.launch {
            while (true) {
                exchangeRateUseCase.getExchangeRate("USD").collect {
                    _rate.postValue(it)
                }
            }
        }
    }

}

object ViewModelFactory : ViewModelProvider.Factory {

    private lateinit var exchangeRateUseCase: ExchangeRateUseCase

    fun initization(useCase: ExchangeRateUseCase) {
        exchangeRateUseCase = useCase
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RatesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return RatesViewModel(exchangeRateUseCase) as T
        }
        throw Exception("Error")
    }
}