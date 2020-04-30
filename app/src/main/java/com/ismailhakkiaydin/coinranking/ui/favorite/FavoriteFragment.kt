package com.ismailhakkiaydin.coinranking.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.ismailhakkiaydin.coinranking.R
import com.ismailhakkiaydin.coinranking.base.BaseVMFragment
import com.ismailhakkiaydin.coinranking.ui.coin.CoinAdapter
import com.ismailhakkiaydin.coinranking.ui.coin.detail.CoinDetailViewModel
import kotlinx.android.synthetic.main.fragment_favorite.*

class FavoriteFragment : BaseVMFragment<CoinDetailViewModel>() {

    override fun getViewModel(): Class<CoinDetailViewModel> = CoinDetailViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getAllCoins().observe(viewLifecycleOwner, Observer {
            it?.let {
                recyclerviewFavorites.layoutManager = GridLayoutManager(context,2)
                recyclerviewFavorites.adapter = CoinAdapter(it){
                    val bundle = bundleOf("coin_details" to it)
                    Navigation.findNavController(view)
                        .navigate(R.id.action_favoriteFragment_to_coinDetailFragment, bundle)
                }
            }
        })
    }

}
