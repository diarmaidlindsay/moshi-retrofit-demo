package tech.diarmaid.moshiretrofitdemo.model

import com.squareup.moshi.Json

data class MakerModel(
        @Json(name = "makers")
        val makers : List<Maker> = ArrayList()
)