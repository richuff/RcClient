package com.richuff.rcclient.feature.splash

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.sql.Time
import kotlin.coroutines.Continuation


class SplashViewModel :ViewModel() {
    private var timer:CountDownTimer? = null

    private val _timeLeft = MutableStateFlow(0L)
    val timeLeft:StateFlow<Long>
        get() = _timeLeft

    /**
     * @author richu
     * @param navToHome
     * 是否跳转到主界面
     */
    val navToHome = MutableStateFlow(false)

    init {
        delayToNext()
    }

    /**
     * @param time 延长的时间，默认为3000,即三秒
     * @author richu
     */
    private fun delayToNext(time: Long = 3000) {
        timer = object : CountDownTimer(time, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                _timeLeft.value = millisUntilFinished/1000 + 1
            }

            override fun onFinish() {
                toNext()
            }
        }.start()
    }

    private fun toNext(){
        navToHome.value = true
    }

    fun skipAd(){
        timer?.cancel()
        toNext()
    }
}