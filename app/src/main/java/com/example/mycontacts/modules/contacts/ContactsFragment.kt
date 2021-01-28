package com.example.mycontacts.modules.contacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mycontacts.CoreFragment
import com.example.mycontacts.R
import com.example.mycontacts.addTo
import com.example.mycontacts.api.models.GetContactsResponseItem
import com.example.mycontacts.databinding.FragmentContactsBinding
import com.example.mycontacts.di.injector

class ContactsFragment : CoreFragment() {

    private lateinit var binding: FragmentContactsBinding
    private val viewModel: ContactsFragmentViewModel? by lazy {
        if (injector != null)
            ViewModelProvider(this,
                injector!!.contactsViewModelFactory()).get(
                ContactsFragmentViewModel::class.java
            )
         else null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_contacts, container, false)
        initializeProgressDialog(getString(R.string.LOADING))
        getContacts()
        return binding.root
    }

    private fun getContacts() {
        showProgress()
        viewModel?.getContacts()?.subscribe({
            loadContacts(it.data ?: listOf())
        }, {
            displayErrorMessage()
        })?.addTo(autoDisposable)
    }

    private fun loadContacts(contacts: List<GetContactsResponseItem?>) {
        hideProgress()
        binding.recyclerContacts.adapter = ContactsAdapter(contacts)
    }

    private fun displayErrorMessage() {
        hideProgress()
        showErrorMessage(getString(R.string.error_message))
    }

}
