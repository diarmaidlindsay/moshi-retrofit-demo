package tech.diarmaid.moshiretrofitdemo

import android.app.Activity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import tech.diarmaid.moshiretrofitdemo.model.MakerModel


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        val makerService: MakerService = retrofit.create(MakerService::class.java)
        val makers: Call<MakerModel> = makerService.getMakers()

        makers.enqueue(object : Callback<MakerModel> {
            override fun onResponse(call: Call<MakerModel>, response: Response<MakerModel>) {
                val makerModel = response.body()
                System.out.println(makerModel?.makers?.get(0)?.makerName)
            }

            override fun onFailure(call: Call<MakerModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    interface MakerService {

        @GET("tcb8m")
        fun getMakers(): Call<MakerModel>
    }
}
