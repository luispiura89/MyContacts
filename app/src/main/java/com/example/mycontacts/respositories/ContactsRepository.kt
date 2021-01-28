package com.example.mycontacts.respositories

import com.example.mycontacts.api.models.GetContactsResponse
import com.example.mycontacts.api.services.ContactsService
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Singleton
class ContactsRepository (private val contactsService: ContactsService) {

    fun getContacts() : Observable<GetContactsResponse> {
        return contactsService.getContacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}