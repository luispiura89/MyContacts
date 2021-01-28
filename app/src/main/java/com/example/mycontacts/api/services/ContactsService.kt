package com.example.mycontacts.api.services

import com.example.mycontacts.api.models.GetContactsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ContactsService {

    @GET("/contacts")
    fun getContacts() : Observable<GetContactsResponse>

}