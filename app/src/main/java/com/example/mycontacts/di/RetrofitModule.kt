package com.example.mycontacts.di

import com.example.mycontacts.api.retrofit.RetrofitBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(): Retrofit {
        return RetrofitBuilder().retrofit()
    }

}