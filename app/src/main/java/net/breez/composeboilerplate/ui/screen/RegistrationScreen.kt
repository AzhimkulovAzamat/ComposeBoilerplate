package net.breez.composeboilerplate.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import net.breez.composeboilerplate.R
import net.breez.composeboilerplate.ui.custom.ImageView
import java.lang.reflect.Field


@Composable
@Preview
fun PreviewRegistrationScreen() {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(model: Any?, textField: @Composable (Field) -> Unit) {
    model ?: return
    val fields = model::class.java.declaredFields

    Surface(
        Modifier.fillMaxSize(),
        color = Color.White
    ) {
        ImageView(
            resourceId = R.drawable.phone_input_circle, modifier = Modifier.wrapContentSize(
                align = Alignment.TopEnd
            )
        )

        Column(
            modifier = Modifier.padding(top = 35.dp)
        ) {
            ImageView(
                resourceId = R.drawable.arrow_back_purple, modifier = Modifier
                    .wrapContentSize(
                        align = Alignment.TopStart
                    )
            )

            for (field in fields) {
                field.isAccessible = true
                textField(field)
            }
            Button(onClick = { Log.d("USER_DATA", model.toString()) }) {
                Text(text = "Confirm")
            }
        }
    }
}