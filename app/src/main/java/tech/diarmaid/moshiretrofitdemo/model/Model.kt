package tech.diarmaid.moshiretrofitdemo.model

import com.squareup.moshi.Json

data class Model(
        @Json(name = "model_code")
        val modelCode : Int = 0,
        @Json(name = "model_name")
        val modelName : String = ""
)