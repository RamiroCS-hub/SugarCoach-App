package com.sugarcoach.ui.sign.view

import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.sugarcoach.ui.base.view.BaseView


interface SignView : BaseView {

    fun onGoogleLogin()
    fun googleSignIntent(mGoogleSignInClient: GoogleSignInClient, RC_SIGN_IN: Int)
    fun onFacebookLogin()
    fun onEmailSign()
    fun showSuccessToast()
}