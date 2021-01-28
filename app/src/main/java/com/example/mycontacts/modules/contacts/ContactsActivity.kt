package com.example.mycontacts.modules.contacts

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mycontacts.CoreActivity
import com.example.mycontacts.R
import com.example.mycontacts.databinding.ActivityContactsBinding

class ContactsActivity : CoreActivity() {

    private lateinit var binding: ActivityContactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_contacts
        )

        onNavigateToFragment(
            ContactsFragment(),
            "CONTACTS",
            R.id.frame_fragment_root,
            addToBackStack = false,
            animated = true
        )

    }

}