package com.example.navcomponenttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navcomponenttest.ui.theme.NavComponentTestTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavComponentTestTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController, "splash",
                        Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        composable("splash") {
                            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text("Splash")
                            }
                        }
                        composable("screen") {
                            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                Text("screen")
                            }
                        }
                    }
                    LaunchedEffect(Unit) {
                        delay(1000)
                        navController.navigate("screen")
                    }
                }
            }
        }
    }
}