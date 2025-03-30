package com.health.dmcare.util

import android.content.Context
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.BulletSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.health.dmcare.R

object TextFormatterHelper {

    fun makeNumberedList(context: Context, textView: TextView, arrayResId: Int) {
        val items = context.resources.getStringArray(arrayResId)
        val spannableStringBuilder = SpannableStringBuilder()

        for (i in items.indices) {
            val item = items[i]

            val spannableString = SpannableString(item + "\n")

            spannableString.setSpan(
                BulletSpan(20, ContextCompat.getColor(context, R.color.black)),
                0,
                item.length,
                SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            spannableStringBuilder.append(spannableString)
        }

        textView.text = spannableStringBuilder
    }
}