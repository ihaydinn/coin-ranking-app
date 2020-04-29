package com.ismailhakkiaydin.coinranking.ui.exchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.ismailhakkiaydin.coinranking.R
import com.ismailhakkiaydin.coinranking.base.BaseVMFragment
import kotlinx.android.synthetic.main.fragment_exchange.*


class ExchangeFragment : BaseVMFragment<ExchangeViewModel>() {

    override fun getViewModel(): Class<ExchangeViewModel> = ExchangeViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exchange, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAllExchanges()
        viewModel.exchangeList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rvExchange.visibility = View.VISIBLE
                rvExchange.layoutManager = LinearLayoutManager(context)
                rvExchange.adapter = ExchangeAdapter(it){
                    Toast.makeText(context, "Exchange Clicked", Toast.LENGTH_SHORT).show()
                }
            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
             if (it){
                 progressBarExchange.visibility = View.VISIBLE
                 rvExchange.visibility = View.GONE
             }else{
                 progressBarExchange.visibility = View.GONE
             }

            }
        })
    }


}
