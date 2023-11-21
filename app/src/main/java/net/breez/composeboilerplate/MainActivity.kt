package net.breez.composeboilerplate

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.breez.composeboilerplate.mvi.signin.PhoneInputState
import net.breez.composeboilerplate.mvi.signin.PhoneInputViewModel
import net.breez.composeboilerplate.mvi.time.travel.debugging.TimeTravelDebugging
import net.breez.composeboilerplate.ui.screen.SplashScreen
import net.breez.composeboilerplate.ui.theme.ComposeBoilerplateTheme
import net.breez.composeboilerplate.mvi.splash.SplashViewModel
import net.breez.composeboilerplate.ui.screen.PhoneInputScreen
import net.breez.domain.model.ProfileModel
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: PhoneInputViewModel by viewModels()
    private val splashViewModel: SplashViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            ComposeBoilerplateTheme {
                val navController = rememberNavController()

                PhoneInputScreen(viewModel = viewModel)
            }
        }
    }
}