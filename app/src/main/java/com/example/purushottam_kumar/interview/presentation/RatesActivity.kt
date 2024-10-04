package com.example.purushottam_kumar.interview.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.purushottam_kumar.R
import com.example.purushottam_kumar.interview.data.remote.RemoteRatesServiceImpl
import com.example.purushottam_kumar.interview.data.repository.ExchangeRateRepositoryImpl
import com.example.purushottam_kumar.interview.domain.use_case.ExchangeRateUseCase


class RatesActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    private val adapter = RatesAdapter()
    private val viewModel: RatesViewModel by viewModels { ViewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rates)

        ViewModelFactory.initization(ExchangeRateUseCase(ExchangeRateRepositoryImpl(
            RemoteRatesServiceImpl()
        )))

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.itemAnimator = null
        viewModel.rates.observe(this){
            adapter.submitList(it)
        }
    }
}