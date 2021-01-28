package com.example.mycontacts.modules.contacts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.R
import com.example.mycontacts.api.models.GetContactsResponseItem
import com.example.mycontacts.databinding.ItemContactBinding

class ContactsAdapter(
    var contacts: List<GetContactsResponseItem?>
) : RecyclerView.Adapter<ContactsAdapter.ContactItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemContactBinding =
            DataBindingUtil.inflate(inflater, R.layout.item_contact, parent, false)

        return ContactItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactItemViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    class ContactItemViewHolder(
        private val binding: ItemContactBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(contact: GetContactsResponseItem?) {
            contact?.let {
                val contactFullName = "${contact.name} ${contact.lastName}"
                binding.textName.text = contactFullName
                binding.textAddress.text = contact.address
                binding.textPhone.text = contact.phone
            }
        }

    }

}