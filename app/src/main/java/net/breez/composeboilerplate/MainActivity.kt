package net.breez.composeboilerplate

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import net.breez.composeboilerplate.ui.screen.SplashScreen
import net.breez.composeboilerplate.ui.theme.ComposeBoilerplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            ComposeBoilerplateTheme {
                SplashScreen()
            }
        }
    }
}