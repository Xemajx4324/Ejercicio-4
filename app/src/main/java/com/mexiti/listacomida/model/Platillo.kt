package com.mexiti.listacomida.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Platillo(
    @StringRes val stringResourceId: Int,
    @DrawableRes val drawableResourceId: Int,
    val precio: String = "MX $100.0",
    val promo: String = "Ahorra hasta el 30%"
)