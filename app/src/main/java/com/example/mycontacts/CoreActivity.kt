package com.example.mycontacts

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

abstract class CoreActivity : AppCompatActivity() {

    open fun onNavigateToFragment(
        newFragment: CoreFragment, tag: String, container: Int,
        addToBackStack: Boolean, animated: Boolean
    ) {
        val transaction: FragmentTransaction = buildTransaction(supportFragmentManager, tag)
        var fragment: Fragment? = supportFragmentManager.findFragmentByTag(tag)

        if(fragment?.javaClass == newFragment.javaClass)
            return

        if (fragment == null) {
            fragment = newFragment
        }

        transaction.replace(container, fragment, tag)
        if (animated) {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        }
        if (addToBackStack) {
            transaction.addToBackStack(tag)
        }
        transaction.commitAllowingStateLoss()

    }

    open fun buildTransaction(manager: FragmentManager, tag: String): FragmentTransaction {
        val transaction = manager.beginTransaction()
        val lastFragment = manager.findFragmentByTag(tag)
        if (lastFragment != null) {
            transaction.remove(lastFragment)
        }
        return transaction
    }
}