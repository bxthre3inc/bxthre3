package com.bxthre3.agentos.ui.theme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
private val cs = darkColorScheme(primary=Accent,secondary=MidBlue,tertiary=Amber,background=Navy,surface=DarkBlue,onPrimary=Navy,onSecondary=White,onTertiary=Navy,onBackground=White,onSurface=White)
@Composable fun AgentOSTheme(c: @Composable ()->Unit) = MaterialTheme(colorScheme=cs, content=c)
