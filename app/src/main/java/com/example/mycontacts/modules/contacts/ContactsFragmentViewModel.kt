package com.example.mycontacts.modules.contacts

import com.example.mycontacts.CoreViewModel
import com.example.mycontacts.api.models.GetContactsResponse
import com.example.mycontacts.api.services.ContactsService
import com.example.mycontacts.respositories.ContactsRepository
import io.reactivex.Observable
import javax.inject.Inject

class ContactsFragmentViewModel @Inject constructor(contactsService: ContactsService) : CoreViewModel() {

    private var contactsRepository = ContactsRepository(contactsService)

    fun getContacts() : Observable<GetContactsResponse> {
        return contactsRepository.getContacts()
    }

}