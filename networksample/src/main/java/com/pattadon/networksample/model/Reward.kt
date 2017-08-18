package com.pattadon.networksample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Reward {

    @SerializedName("rewards_name")
    @Expose
    var rewardsName: String? = null
    @SerializedName("rewards_image")
    @Expose
    var rewardsImage: String? = null
    @SerializedName("rewards_detail")
    @Expose
    var rewardsDetail: String? = null

}
