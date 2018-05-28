package tech.diarmaid.moshiretrofitdemo.model

import com.squareup.moshi.Json

data class Maker(
        @Json(name = "maker_code")
        val makerCode : Int = 0,
        @Json(name = "maker_name")
        val makerName : String = "",
        @Json(name = "models")
        val models : List<Model> = ArrayList()
)