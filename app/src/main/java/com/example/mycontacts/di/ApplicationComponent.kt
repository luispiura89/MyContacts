package com.example.mycontacts.di

import android.app.Application
import android.content.Context
import com.example.mycontacts.MyContactsApplication
import com.example.mycontacts.modules.contacts.ContactsFragmentViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            ApiModule::class,
            RetrofitModule::class,
            AndroidInjectionModule::class
        ]
)
interface ApplicationComponent : AndroidInjector<MyContactsApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context) : Builder
        fun build() : ApplicationComponent
    }

    fun contactsViewModelFactory(): ViewModelFactory<ContactsFragmentViewModel>

    fun inject(app: Application)

}