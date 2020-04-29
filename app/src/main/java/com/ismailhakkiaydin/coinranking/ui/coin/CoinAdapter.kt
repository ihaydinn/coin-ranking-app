package com.ismailhakkiaydin.coinranking.ui.coin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ismailhakkiaydin.coinranking.R
import com.ismailhakkiaydin.coinranking.databinding.ItemCoinBinding
import com.ismailhakkiaydin.coinranking.model.coin.CoinResult

class CoinAdapter(val coinsList: List<CoinResult.Data.Coin>, val onItemClick:(CoinResult.Data.Coin)->Unit):RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {
    class CoinViewHolder(var view: ItemCoinBinding): RecyclerView.ViewHolder(view.root) {
        fun bind(coin: CoinResult.Data.Coin, onItemClick: (CoinResult.Data.Coin) -> Unit){
            itemView.setOnClickListener { onItemClick(coin) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemCoinBinding>(inflater, R.layout.item_coin, parent,false)
        return CoinViewHolder(view)
    }

    override fun getItemCount(): Int = coinsList.size

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.view.coin = coinsList[position]
        holder.bind(coinsList[position],onItemClick)
    }
}