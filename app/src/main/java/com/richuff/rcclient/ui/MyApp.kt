package com.richuff.rcclient.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.richuff.rcclient.feature.main.mainScreen
import com.richuff.rcclient.feature.main.navToHome
import com.richuff.rcclient.feature.splash.SPLASH_NAV
import com.richuff.rcclient.feature.splash.splashScreen

@Composable
fun MyApp(controller:NavHostController){
    NavHost(navController = controller, startDestination = SPLASH_NAV){
        splashScreen(toMain = controller::navToHome)
        mainScreen()
    }
}