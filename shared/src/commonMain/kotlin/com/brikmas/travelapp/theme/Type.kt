package com.brikmas.travelapp.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.brikmas.travelapp.SharedRes
import dev.icerock.moko.resources.compose.asFont

@Composable
fun getTypography(): Typography {
    val sfProFamily = FontFamily(
        SharedRes.fonts.sf_pro_regular.sf_pro_regular.asFont(weight = FontWeight.W400)!!,
        SharedRes.fonts.sf_pro_medium.sf_pro_medium.asFont(weight = FontWeight.W500)!!,
        SharedRes.fonts.sf_pro_bold.sf_pro_bold.asFont(weight = FontWeight.W700)!!
    )
    val typography = Typography(
        titleLarge = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        ),
        titleMedium = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
        ),
        titleSmall = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            lineHeight = 28.sp,
            letterSpacing = 0.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 18.sp,
        ),
        bodyMedium  = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
        ),
        bodySmall  = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 9.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
        ),
        headlineLarge = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
        ),
        headlineSmall = TextStyle(
            fontFamily = sfProFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 10.sp,
        ),
    )
    return typography
}
