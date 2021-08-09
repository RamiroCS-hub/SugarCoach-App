package com.sugarcoach.ui.signEmail.presenter

import android.content.Intent
import com.sugarcoach.ui.base.presenter.Presenter
import com.sugarcoach.ui.signEmail.interactor.SignEmailInteractorImp
import com.sugarcoach.ui.signEmail.view.SignEmailView


interface SignEmailPresenterImp<V : SignEmailView, I : SignEmailInteractorImp> : Presenter<V, I>{
    fun signIn(username: String, email: String, password: String)
    fun googleLogin(client: String)
    fun facebookLogin()
    fun activityResult(requestCode: Int, resultCode: Int, data: Intent?)

}