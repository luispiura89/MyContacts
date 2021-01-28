package com.example.mycontacts

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog

abstract class CoreFragment : Fragment() {
    private var pDialog: SweetAlertDialog? = null
    private var errorDialog: SweetAlertDialog? = null
    private var loadingMessage: String? = null
    protected val autoDisposable = AutoDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        autoDisposable.bindTo(lifecycle)
    }

    fun initializeProgressDialog(message: String) {
        loadingMessage = message
    }

    fun showProgress(message: String = loadingMessage ?: "") {
        if (pDialog?.isShowing == false || pDialog == null) {
            pDialog = SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE)
            pDialog?.progressHelper?.barColor = Color.parseColor("#BD6AD3")
            pDialog?.titleText = message
            pDialog?.setCancelable(false)
            pDialog?.show()
        }
    }

    fun hideProgress() {
        if (pDialog?.isShowing == true) {
            pDialog?.dismissWithAnimation()
        }
    }

    fun showErrorMessage(message: String) {
        if (isAdded && activity?.isFinishing == false) {
            errorDialog = SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
            errorDialog?.titleText = getString(R.string.error)
            errorDialog?.confirmButtonBackgroundColor = Color.parseColor("#D70101")
            errorDialog?.contentText = message
            errorDialog?.show()
        }
    }

    override fun onPause() {
        super.onPause()
        pDialog?.dismiss()
        pDialog = null
        errorDialog?.dismiss()
        errorDialog = null
    }
}