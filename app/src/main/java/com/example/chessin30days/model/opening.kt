package com.example.chessin30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class opening(
    @StringRes val day_Number:Int,
    @StringRes val opening_Name: Int,
    @DrawableRes val opening_Image: Int,
    @StringRes val opening_Des: Int
)
