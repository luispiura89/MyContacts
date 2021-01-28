package com.example.mycontacts.di

import com.example.mycontacts.api.services.ContactsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule  {

    @Provides
    @Singleton
    internal fun provideContactsService(retrofit: Retrofit): ContactsService {
        return retrofit.create(ContactsService::class.java)
    }

}