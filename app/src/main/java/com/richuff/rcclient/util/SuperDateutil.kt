package com.richuff.rcclient.util

import android.icu.util.Calendar

object SuperDateUtil {
    fun getYear():Int{
        return Calendar.getInstance().get(Calendar.YEAR)
    }
}