package com.example.mycityapp.ui.theme

import androidx.annotation.StringRes
import com.example.mycityapp.ui.theme.Data.data

data class OrderUiState(
    val currentindex : Int = 0,
   @StringRes val currentDescription: Int = data[currentindex].description,
)
