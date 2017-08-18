package com.pattadon.networksample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Results {

    @SerializedName("term_title")
    @Expose
    var termTitle: String? = null
    @SerializedName("term_detail")
    @Expose
    var termDetail: String? = null
    @SerializedName("rewords_title")
    @Expose
    var rewordsTitle: String? = null
    @SerializedName("rewards_detail")
    @Expose
    var rewardsDetail: String? = null
    @SerializedName("rewards")
    @Expose
    var rewards: List<Reward>? = null

}
