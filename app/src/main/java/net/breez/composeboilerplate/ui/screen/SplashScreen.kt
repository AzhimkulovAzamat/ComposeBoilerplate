package net.breez.composeboilerplate.ui.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import net.breez.composeboilerplate.R
import net.breez.composeboilerplate.ui.custom.ImageView
import net.breez.composeboilerplate.ui.theme.*
import net.breez.composeboilerplate.mvi.splash.SplashViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import net.breez.domain.UIState

@Composable
@Preview
fun PreviewSplashScreen() {
    SplashScreen(viewModel = null)
}

@Composable
fun <T> HandleState(uiState: UIState<T>, onSuccess: @Composable (T) -> Unit) {
    when (uiState) {
        is UIState.Success -> onSuccess(uiState.data)
        is UIState.Error -> {
            Toast.makeText(LocalContext.current, uiState.error.message, Toast.LENGTH_LONG).show()
        }

        is UIState.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Composable
fun SplashScreen(viewModel: SplashViewModel?) {
    viewModel ?: return

    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadData()
    }

    Surface(
        Modifier.fillMaxSize(),
        color = Color.White
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (bubbles, roundIcon, bubble, title, subTitle) = createRefs()

            ImageView(
                resourceId = R.drawable.round_main_icon,
                modifier = Modifier
                    .constrainAs(roundIcon) {
                        end.linkTo(parent.end, margin = 30.dp)
                        top.linkTo(parent.top, margin = 16.dp + 35.dp)
                    }
                    .clickable { viewModel.loadData() })
            ImageView(
                resourceId = R.drawable.splash_buble_main,
                modifier = Modifier.constrainAs(bubbles) {
                    top.linkTo(parent.top, margin = 29.dp + 35.dp)
                })
            ImageView(
                resourceId = R.drawable.single_bubble_main,
                modifier = Modifier.constrainAs(bubble) {
                    end.linkTo(parent.end)
                    top.linkTo(bubbles.bottom, margin = 2.dp)
                })
            Text(
                text = "Главное внутри...",
                modifier = Modifier.constrainAs(title) {
                    start.linkTo(parent.start, margin = 32.dp)
                    top.linkTo(bubble.bottom)
                    bottom.linkTo(bubble.bottom)
                },
                style = Typography.superTitle
            )
            Text(
                text = "Самое",
                modifier = Modifier
                    .constrainAs(subTitle) {
                        start.linkTo(parent.start, margin = 20.dp)
                        bottom.linkTo(title.top, margin = 5.dp)
                    }
                    .rotate(-26.26f)
                    .clip(RoundedCornerShape(30.dp))
                    .background(AccentGreen)
                    .padding(10.dp, 5.dp),
                style = Typography.mediumTitle,
                color = Color.White
            )
        }
    }
}