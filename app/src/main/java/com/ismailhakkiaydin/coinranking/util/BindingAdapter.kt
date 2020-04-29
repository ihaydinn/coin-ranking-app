package com.ismailhakkiaydin.coinranking.util

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
import com.ismailhakkiaydin.coinranking.R


@BindingAdapter("android:stringFormat")
fun stringFormat(view: TextView, value: Double) {
    var formated = String.format("%.2f", value)
    view.text = formated
}

@BindingAdapter("android:converterInt")
fun convertToInt(view: TextView, value:Double){
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
fun changedPrice(view:TextView, value: Double){
    if (value > 0){
        view.setTextColor(view.resources.getColor(R.color.colorChangeUp))
    }else{
        view.setTextColor(view.resources.getColor(R.color.colorChangeDown))
    }
}

@BindingAdapter("android:imageUrl")
fun loadImage(imageView: ImageView, url: String) {
    GlideToVectorYou.init().with(imageView.context!!).load(Uri.parse(url),imageView)
}