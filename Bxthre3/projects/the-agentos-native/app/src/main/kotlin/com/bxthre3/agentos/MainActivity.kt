package com.bxthre3.agentos

import android.os.Bundle
import androidx.activity.compose.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bxthre3.agentos.ui.AgentOSApp
import com.bxthre3.agentos.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        setContent {
            AgentOSTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    LockScreen()
                }
            }
        }
    }

    @Composable
    fun LockScreen() {
        val prefs = remember { getSharedPreferences("agentos_prefs", MODE_PRIVATE) }
        val storedPin = remember { prefs.getString("pin", null) }
        var pin by remember { mutableStateOf("") }
        var error by remember { mutableStateOf(false) }
        var isSettingPin by remember { mutableStateOf(storedPin == null) }
        var confirmPin by remember { mutableStateOf("") }

        val accent = Color(0xFF00D4AA)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Navy)
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                // Lock icon
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    tint = accent,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "AGENTOS",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Black,
                    color = accent
                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    if (isSettingPin) "Set your PIN"
                    else if (error) "Incorrect PIN — try again"
                    else "Enter your PIN",
                    fontSize = 14.sp,
                    color = if (error) Color(0xFFEF4444) else Gray,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(24.dp))

                // PIN dots
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    repeat(4) { i ->
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(
                                    if (i < pin.length) accent else DarkBlue,
                                    CircleShape
                                )
                                .border(1.dp, if (i < pin.length) accent else Gray, CircleShape)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))

                // Number pad
                val rows = listOf(
                    listOf("1","2","3"),
                    listOf("4","5","6"),
                    listOf("7","8","9"),
                    listOf("","0","⌫")
                )
                for (row in rows) {
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.padding(vertical = 4.dp)) {
                        for (key in row) {
                            if (key.isEmpty()) {
                                Spacer(modifier = Modifier.size(72.dp))
                            } else {
                                Box(
                                    modifier = Modifier
                                        .size(72.dp)
                                        .background(DarkBlue, RoundedCornerShape(16.dp))
                                        .border(1.dp, MidBlue, RoundedCornerShape(16.dp))
                                        .clickable {
                                            error = false
                                            when {
                                                key == "⌫" -> {
                                                    if (pin.isNotEmpty()) pin = pin.dropLast(1)
                                                }
                                                pin.length < 4 -> {
                                                    pin += key
                                                    if (pin.length == 4) {
                                                        if (isSettingPin) {
                                                            if (confirmPin.isEmpty) {
                                                                confirmPin = pin
                                                                pin = ""
                                                            } else {
                                                                if (pin == confirmPin) {
                                                                    prefs.edit().putString("pin", pin).apply()
                                                                    isSettingPin = false
                                                                    pin = ""
                                                                } else {
                                                                    error = true
                                                                    pin = ""
                                                                    confirmPin = ""
                                                                }
                                                            }
                                                        } else {
                                                            if (pin == storedPin) {
                                                                // Unlock — navigate to app
                                                                setContent {
                                                                    Surface(modifier = Modifier.fillMaxSize()) {
                                                                        AgentOSApp()
                                                                    }
                                                                }
                                                            } else {
                                                                error = true
                                                                pin = ""
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        if (key == "⌫") "⌫" else key,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (key == "⌫") Color(0xFFEF4444) else White
                                    )
                                }
                            }
                        }
                    }
                }

                if (isSettingPin && confirmPin.isNotEmpty) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Confirm your PIN",
                        fontSize = 12.sp,
                        color = Gray
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    "Private — brodiblanco only",
                    fontSize = 10.sp,
                    color = Gray.copy(alpha = 0.5f)
                )
            }
        }
    }
}
