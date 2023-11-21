package net.breez.composeboilerplate.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import net.breez.composeboilerplate.R

val fonts = FontFamily(
    Font(R.font.mazzard_soft_bold, weight = FontWeight.Bold),
    Font(R.font.mazzard_soft_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.mazzard_soft_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.mazzard_soft_regular, weight = FontWeight.Normal)
    )

val Typography.superTitle: TextStyle
    get() = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W700,
        fontSize = 32.sp,
        lineHeight =  33.5.sp,
        color = MainPurple
    )

val Typography.mediumTitle: TextStyle
    get() = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W700,
        fontSize = 17.sp,
        lineHeight =  22.sp,
        color = SubtitleGray
    )

val Typography.smallTitle: TextStyle
    get() = TextStyle(
        fontFamily = fonts,
        fontWeight = FontWeight.W400,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        color = SubtitleGray
    )