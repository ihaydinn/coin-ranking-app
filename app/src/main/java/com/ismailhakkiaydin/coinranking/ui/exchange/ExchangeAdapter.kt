package com.ismailhakkiaydin.coinranking.ui.exchange

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ismailhakkiaydin.coinranking.R
import com.ismailhakkiaydin.coinranking.databinding.ItemExchangeBinding
import com.ismailhakkiaydin.coinranking.model.exchange.ExchangeResult

class ExchangeAdapter(val exchangeList: List<ExchangeResult.Data.Exchange>, val onItemClick:(ExchangeResult.Data.Exchange)->Unit): RecyclerView.Adapter<ExchangeAdapter.ExchangeViewHolder>() {
    class ExchangeViewHolder(var view : ItemExchangeBinding):RecyclerView.ViewHolder(view.root) {
        fun bind(exchange: ExchangeResult.Data.Exchange, onItemClick: (ExchangeResult.Data.Exchange) -> Unit){
            itemView.setOnClickListener {
                onItemClick(exchange)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemExchangeBinding>(inflate, R.layout.item_exchange, parent, false)
        return ExchangeViewHolder(view)
    }

    override fun getItemCount(): Int = exchangeList.size

    override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
        holder.view.exchange = exchangeList[position]
        holder.bind(exchangeList[position], onItemClick)
    }
}