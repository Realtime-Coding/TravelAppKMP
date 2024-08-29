package theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.raleway_light
import travelbuddy.composeapp.generated.resources.raleway_medium
import travelbuddy.composeapp.generated.resources.raleway_regular
import travelbuddy.composeapp.generated.resources.raleway_semibold
import org.jetbrains.compose.resources.Font
import androidx.compose.material3.Typography


private val craneLight: FontFamily
    @Composable
    get() =
        FontFamily(Font(Res.font.raleway_light, FontWeight.W300))
val craneRegular: FontFamily
    @Composable
    get() =
        FontFamily(Font(Res.font.raleway_regular, FontWeight.W400))
private val craneMedium: FontFamily
    @Composable
    get() =
        FontFamily(Font(Res.font.raleway_medium, FontWeight.W500))
private val craneSemiBold: FontFamily
    @Composable
    get() =
        FontFamily(Font(Res.font.raleway_semibold, FontWeight.W600))

val titleBarStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = craneSemiBold,
        fontWeight = FontWeight.W600,
        fontSize = 30.sp
    )

val subTitleBarStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = craneSemiBold,
        fontWeight = FontWeight.W600,
        fontSize = 20.sp
    )

val primaryButtonStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = craneMedium,
        fontWeight = FontWeight.W500,
        fontSize = 15.sp
    )

val primaryInputStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = craneRegular,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp
    )

val primaryLableStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = craneRegular,
        fontWeight = FontWeight.W400,
        fontSize = 15.sp
    )

val secondaryLableStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = craneRegular,
        fontWeight = FontWeight.W300,
        fontSize = 15.sp
    )

val captionTextStyle: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = craneRegular,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp
    )

@Composable
fun Typography(): Typography {
    val craneTypography = Typography(
        titleLarge = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W300,
            fontSize = 30.sp
        ),
        titleMedium = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W400,
            fontSize = 28.sp
        ),
        titleSmall = TextStyle(
            fontFamily = craneSemiBold,
            fontWeight = FontWeight.W600,
            fontSize = 26.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = craneSemiBold,
            fontWeight = FontWeight.W600,
            fontSize = 24.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = craneSemiBold,
            fontWeight = FontWeight.W600,
            fontSize = 22.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W400,
            fontSize = 20.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W500,
            fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        ),
        bodySmall = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W300,
            fontSize = 12.sp
        ),
        displayLarge = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp
        ),
        displayMedium = TextStyle(
            fontFamily = craneSemiBold,
            fontWeight = FontWeight.W600,
            fontSize = 10.sp
        ),
        displaySmall = TextStyle(
            fontFamily = craneMedium,
            fontWeight = FontWeight.W500,
            fontSize = 8.sp
        ),
        labelLarge = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W600,
            fontSize = 16.sp
        ),
        labelMedium = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp
        ),
        labelSmall = TextStyle(
            fontFamily = craneRegular,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp
        )
    )

    return craneTypography
}