package com.mexiti.listacomida.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mexiti.listacomida.R

private val AbrilFatface = FontFamily(Font(R.font.abril_fatface))
private val MontserratRegular = FontFamily(Font(R.font.montserrat_regular, weight = FontWeight.Normal))
private val MontserratBold = FontFamily(Font(R.font.montserrat_bold, weight = FontWeight.Bold))

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = AbrilFatface, fontWeight = FontWeight.Normal, fontSize = 34.sp
    ),
    titleLarge = TextStyle(
        fontFamily = MontserratBold, fontWeight = FontWeight.Bold, fontSize = 22.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = MontserratRegular, fontWeight = FontWeight.Normal, fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = MontserratBold, fontWeight = FontWeight.Bold, fontSize = 16.sp
    )
)
