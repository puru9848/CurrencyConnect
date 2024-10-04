package com.example.purushottam_kumar.interview.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.purushottam_kumar.R
import com.example.purushottam_kumar.interview.domain.Rate

class RatesAdapter : ListAdapter<Rate, RatesAdapter.ViewHolder>(DiffUtils()) {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val currency: TextView = itemView.findViewById(R.id.currency)
        private val value: TextView = itemView.findViewById(R.id.value)

        fun bind(rate: Rate) {
            currency.text = rate.currency
            value.text = rate.value
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rates, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }
}

class DiffUtils : DiffUtil.ItemCallback<Rate>(){

    override fun areItemsTheSame(oldItem: Rate, newItem: Rate): Boolean {
        return oldItem.currency == newItem.currency
    }

    override fun areContentsTheSame(oldItem: Rate, newItem: Rate): Boolean {
        return oldItem == newItem
    }

}