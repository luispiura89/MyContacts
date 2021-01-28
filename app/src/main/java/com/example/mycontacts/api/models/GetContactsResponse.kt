package com.example.mycontacts.api.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetContactsResponse(

    @field:SerializedName("items")
    val data: List<GetContactsResponseItem?>? = null,

    @field:SerializedName("status")
    val status: String? = null

) : Serializable