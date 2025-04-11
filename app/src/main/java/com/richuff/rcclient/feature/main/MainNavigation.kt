package com.richuff.rcclient.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.richuff.rcclient.feature.splash.SPLASH_NAV

const val MAIN_NAV:String = "main"

fun NavController.navToHome(){
    navigate(MAIN_NAV){
        //不开启多个界面
        launchSingleTop = true
        popUpTo(SPLASH_NAV){
            //关闭SPLASH_NAV以前的所有界面
            inclusive = true
        }
    }
}

fun NavGraphBuilder.mainScreen(){
    composable(MAIN_NAV) {
        MainRoute()
    }
}