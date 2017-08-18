package com.pattadon.networksample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pattadon.networksample.model.Example
import com.pattadon.networksample.service.SampleService
import com.pattadon.sampleapplicationproject.network.RetrofitManager
import kotlinx.android.synthetic.main.activity_network_sample.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkSampleActivity : AppCompatActivity() {

    val addfunction : (Int , Int) -> Int = {
        a : Int , b : Int -> a + b
    }

    var sampleService : SampleService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_sample)

        sampleService = RetrofitManager.instance.retrofit.create(SampleService::class.java)

        callservice_btn.setOnClickListener {
            callService()
        }
    }

    fun callService(){
        sampleService?.exampleData("en")?.enqueue(object : Callback<Example>{
            override fun onResponse(call: Call<Example>?, response: Response<Example>?) {
                if (response!!.isSuccessful){
                    callservice_tv.text = response.body()?.toString()
                }
            }

            override fun onFailure(call: Call<Example>?, t: Throwable?) {
                callservice_tv.text = t.toString()

            }
        })
    }
}
