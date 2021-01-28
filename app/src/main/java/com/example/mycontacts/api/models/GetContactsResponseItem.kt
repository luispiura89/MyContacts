package com.example.mycontacts.api.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class GetContactsResponseItem(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("last_name")
    val lastName: Int? = null,

    @field:SerializedName("age")
    val age: Int? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null

) : Serializable