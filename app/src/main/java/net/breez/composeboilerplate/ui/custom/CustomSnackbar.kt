package net.breez.composeboilerplate.ui.custom

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.breez.composeboilerplate.R
import net.breez.composeboilerplate.mvi.redux.OneShotEvent
import net.breez.composeboilerplate.ui.theme.MainPurple
import net.breez.composeboilerplate.ui.theme.Typography
import net.breez.composeboilerplate.ui.theme.mediumTitle
import java.util.Locale

@Preview
@Composable
fun CustomSnackbar(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState = SnackbarHostState(),
) {
    SnackbarHost(
        snackbarHostState, modifier = modifier
    ) {
        CustomSnackbar(snackbarData = it)
    }
}

@Preview
@Composable
fun CustomSnackbar(
    modifier: Modifier = Modifier, snackbarData: SnackbarData = getSnackbarData()
) {
    Surface(
        shape = RoundedCornerShape(13.dp),
        color = MainPurple,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 11.dp + 35.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 10.dp)
        ) {
            val icon =
                (snackbarData.visuals as? SnackbarOptions)?.icon ?: R.drawable.ic_snackbar_icon
            ImageView(resourceId = icon)
            Text(
                text = snackbarData.visuals.message,
                color = Color.White,
                modifier = Modifier.padding(start = 25.dp),
                style = Typography.mediumTitle
            )

            Spacer(Modifier.weight(1f))

            snackbarData.visuals.actionLabel?.let { actionLabel ->
                ImageView(
                    resourceId = actionLabel.toInt(),
                    modifier = Modifier
                        .padding(end = 14.dp)
                        .clickable { snackbarData.performAction() },
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
suspend fun SnackbarHostState.showSnackbar(
    @DrawableRes icon: Int,
    message: String,
    @DrawableRes actionIcon: Int? = null,
    duration: SnackbarDuration = SnackbarDuration.Short,
    withDismissAction: Boolean = false
) {
    val options = SnackbarOptions(
        message, icon, actionIcon, duration, withDismissAction
    )
    showSnackbar(options)
}

private fun getSnackbarData(): SnackbarData {
    return object : SnackbarData {
        override val visuals: SnackbarOptions = SnackbarOptions(
            "Доступно к списанию 120 баллов",
            R.drawable.ic_snackbar_icon,
            R.drawable.close_button,
            SnackbarDuration.Short,
            true
        )

        override fun dismiss() {}

        override fun performAction() {}
    }
}

class SnackbarOptions(
    override val message: String,
    val icon: Int = R.drawable.ic_snackbar_icon,
    private val actionIcon: Int? = R.drawable.close_button,
    override val duration: SnackbarDuration = SnackbarDuration.Short,
    override val withDismissAction: Boolean = true
) : SnackbarVisuals {
    override val actionLabel: String?
        get() = actionIcon?.toString()

    fun toOneShotEvent(): OneShotEvent.ShowSnackBar {
        return OneShotEvent.ShowSnackBar(this)
    }
}