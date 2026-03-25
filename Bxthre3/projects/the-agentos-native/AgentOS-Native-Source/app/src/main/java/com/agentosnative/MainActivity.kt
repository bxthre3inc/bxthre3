package com.agentosnative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.agentosnative.ui.navigation.AOSNavHost
import com.agentosnative.ui.theme.AgentOSNativeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgentOSNativeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AOSNavHost()
                }
            }
        }
    }
}
