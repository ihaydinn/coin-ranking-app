package com.ismailhakkiaydin.coinranking.ui.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ismailhakkiaydin.coinranking.R
import com.ismailhakkiaydin.coinranking.base.BaseVMFragment
import kotlinx.android.synthetic.main.fragment_coin.*


class CoinFragment : BaseVMFragment<CoinViewModel>() {

    override fun getViewModel(): Class<CoinViewModel> = CoinViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coin, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAllCoins()

        viewModel.coinsList.observe(viewLifecycleOwner, Observer { coins ->
            coins?.let {
                rvCoins.visibility = View.VISIBLE
                rvCoins.layoutManager = GridLayoutManager(context, 2)
                rvCoins.adapter = CoinAdapter(coins){
                    Toast.makeText(context, "Item Clicked", Toast.LENGTH_SHORT).show()
                }
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer { loading ->
            loading?.let {
                if (it){
                    progressBarCoins.visibility = View.VISIBLE
                    rvCoins.visibility = View.GONE
                }else{
                    progressBarCoins.visibility = View.GONE
                }
            }
        })
    }

}
