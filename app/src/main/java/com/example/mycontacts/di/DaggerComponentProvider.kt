package com.example.mycontacts.di

import androidx.fragment.app.Fragment

interface DaggerComponentProvider {
    val component: ApplicationComponent
}

val Fragment.injector get() = (activity?.applicationContext as? DaggerComponentProvider)?.component