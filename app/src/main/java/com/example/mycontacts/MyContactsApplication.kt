package com.example.mycontacts

import android.app.Application
import dagger.android.*
import com.example.mycontacts.di.ApplicationComponent
import com.example.mycontacts.di.DaggerApplicationComponent
import com.example.mycontacts.di.DaggerComponentProvider
import javax.inject.Inject

class MyContactsApplication : Application(), DaggerComponentProvider, HasAndroidInjector {

    private lateinit var appComponent: ApplicationComponent
    @set:Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector() = androidInjector

    override val component: ApplicationComponent by lazy {
        appComponent
    }

    override fun onCreate() {
        appComponent = getInjector()
        super.onCreate()
    }

    private fun getInjector(): ApplicationComponent {
        val appComponent = DaggerApplicationComponent
            .builder()
            .applicationContext(applicationContext)
            .build()

        appComponent.inject(this)
        return appComponent
    }

}