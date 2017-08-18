package com.pattadon.networksample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Example {

    @SerializedName("error_code")
    @Expose
    var errorCode: String? = null
    @SerializedName("error_msg")
    @Expose
    var errorMsg: String? = null
    @SerializedName("results")
    @Expose
    var results: Results? = null

}
