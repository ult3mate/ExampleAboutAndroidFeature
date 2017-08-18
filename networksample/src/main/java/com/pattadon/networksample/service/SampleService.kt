package com.pattadon.networksample.service

import com.pattadon.networksample.model.Example
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by pattadon on 8/18/17.
 */
interface SampleService {

    @GET("term_condition")
    fun exampleData(@Query("lang") language: String): Call<Example>
}