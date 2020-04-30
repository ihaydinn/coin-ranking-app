package com.ismailhakkiaydin.coinranking.ui.coin.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

import com.ismailhakkiaydin.coinranking.R
import com.ismailhakkiaydin.coinranking.base.BaseFragment
import com.ismailhakkiaydin.coinranking.base.BaseVMFragment
import com.ismailhakkiaydin.coinranking.databinding.FragmentCoinDetailBinding
import com.ismailhakkiaydin.coinranking.model.coin.CoinResult
import com.ismailhakkiaydin.coinranking.model.history.CoinHistoryResult
import com.ismailhakkiaydin.coinranking.util.DateFormatter
import com.ismailhakkiaydin.coinranking.util.convertFloat
import kotlinx.android.synthetic.main.fragment_coin.*
import kotlinx.android.synthetic.main.fragment_coin_detail.*
import java.time.format.DateTimeFormatter


class CoinDetailFragment : BaseFragment<FragmentCoinDetailBinding,CoinDetailViewModel>() {

    private var coinDetails: CoinResult.Data.Coin? = null
    private var isFav: Boolean? = null

    override fun getLayoutRes(): Int = R.layout.fragment_coin_detail
    override fun getViewModel(): Class<CoinDetailViewModel> = CoinDetailViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        arguments?.let {
            coinDetails = it?.getParcelable("coin_details")
            dataBinding.coinDetail = coinDetails
            checkFav()
            dataBinding.imgFavorite.setOnClickListener {
                favorite()
            }
        }

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var coinResult =  arguments?.getParcelable<CoinResult.Data.Coin>("coin_details")

        viewModel.getAllCoinHisory(coinResult!!.coinId)
        viewModel.coinHistoryList.observe(viewLifecycleOwner, Observer {
            it?.let {

                val lineEntries = mutableListOf<Entry>()

                for((index, value) in it.withIndex()){
                    lineEntries.add(Entry(index.toFloat(), convertFloat(value.price)))
                }

                lineChart.xAxis.valueFormatter = DateFormatter(it)

                val lineDataSet = LineDataSet(lineEntries,"deneme")
                lineChart.data = LineData(lineDataSet)
                lineDataSet.setDrawValues(false)
                lineDataSet.setDrawFilled(true)
                lineDataSet.lineWidth = 1f
                lineDataSet.fillColor = R.color.colorAccent
                lineDataSet.fillAlpha = R.color.colorChangeUp

                lineChart.xAxis.labelRotationAngle = 0f
                // lineChart.axisRight.isEnabled = false
                lineChart.setTouchEnabled(true)
                lineChart.setPinchZoom(true)

                lineChart.description.text = "Days"
                lineChart.setNoDataText("No Data Yet!")
                lineChart.animateX(2000, Easing.EaseInOutCirc)
                val markerView = CustomMarker(requireContext(), R.layout.marker_view)
                lineChart.marker = markerView

                lineChart.invalidate()
            }


        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it){
                    progressBarDetails.visibility = View.VISIBLE
                    cardView.visibility = View.GONE
                    lineChart.visibility = View.GONE
                }else{
                    progressBarDetails.visibility = View.GONE
                    cardView.visibility = View.VISIBLE
                    lineChart.visibility = View.VISIBLE
                }
            }
        })

    }

    private fun favorite(){
        if (isFav!!){
            coinDetails?.let { viewModel.deleteCoin(it) }
            Toast.makeText(context, "Removed", Toast.LENGTH_SHORT).show()
        }else{
            coinDetails?.let { viewModel.insertCoin(it) }
            Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFav(){
        viewModel.getSingleCoin(coinDetails!!.coinId).observe(viewLifecycleOwner, Observer {
            if (it != null){
                dataBinding.imgFavorite.setImageResource(R.drawable.ic_favorite_full)
                isFav = true
            }else{
                dataBinding.imgFavorite.setImageResource(R.drawable.ic_favorite)
                isFav = false
            }
        })
    }


}
