package com.ismailhakkiaydin.coinranking.util

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.ismailhakkiaydin.coinranking.R
import com.ismailhakkiaydin.coinranking.model.history.CoinHistoryResult
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

class DateFormatter(list: List<CoinHistoryResult.Data.History>) : ValueFormatter() {
    private val chartDataListItems: List<CoinHistoryResult.Data.History> = list

    override fun getFormattedValue(value: Float): String {
        val item: Long = chartDataListItems[value.toInt()].timestamp

        var converter = SimpleDateFormat("d MMM hh:mm a", Locale("en"))
        var convertedDay = converter.format(Date(item))

        return convertedDay

    }
}


fun convertFloat(value: String): Float {
    var a = value.toFloat()
    return a
}

@BindingAdapter("android:numberFormat")
fun numberFormat(view: TextView, value: Long){
    var df = DecimalFormat("#,###,##0.00")
    var formatted = df.format(value)
    var convert = formatted.toString()
    view.text = convert
}

@BindingAdapter("android:stringFormat")
fun stringFormat(view: TextView, value: Double) {
    var formated = String.format("%.2f", value)
    view.text = formated
}

@BindingAdapter("android:converterInt")
fun convertToInt(view: TextView, value: Double) {
    var valueInt = value.toInt()
    var valueString = valueInt.toString()
    view.text = valueString
}

@BindingAdapter("android:formatPrice")
fun formatPrice(view: TextView, value: String) {
    var convertTo = value.toDouble()
    var formated = String.format("%.2f", convertTo)
    view.text = formated
}

@BindingAdapter("android:changedPrice")
fun changedPrice(view: TextView, value: Double) {
    if (value > 0) {
        view.setTextColor(view.resources.getColor(R.color.colorChangeUp))
    } else {
        view.setTextColor(view.resources.getColor(R.color.colorChangeDown))
    }
}

@BindingAdapter("android:imageUrl")
fun loadImage(imageView: ImageView, url: String) {
    GlideToVectorYou.init().with(imageView.context!!).load(Uri.parse(url), imageView)
}