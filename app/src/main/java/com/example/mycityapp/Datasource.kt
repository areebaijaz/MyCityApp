package com.example.mycityapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Datasource(
    @StringRes val resnames: Int,
    @StringRes val description: Int
)

data class Dataofpark(
    @StringRes val parknames: Int,
   @StringRes val descriptionpark: Int
)

data class Dataofcofeeshops(
    @StringRes val shopsname: Int,
    @StringRes val descriptioncofee: Int
)

data class Dataofmalls(
    @StringRes val mallsname: Int,
    @StringRes val descriptionmall: Int
)
