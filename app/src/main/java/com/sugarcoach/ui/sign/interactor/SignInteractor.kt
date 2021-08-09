package com.sugarcoach.ui.sign.interactor

import com.facebook.AccessToken
import com.google.gson.GsonBuilder
import com.sugarcoach.data.database.repository.user.User
import com.sugarcoach.data.database.repository.user.UserRepo
import com.sugarcoach.data.network.ApiHelper
import com.sugarcoach.data.network.LoginRequest
import com.sugarcoach.data.network.LoginResponse
import com.sugarcoach.data.ui.base.interactor.BaseInteractor
import com.sugarcoach.di.preferences.PreferenceHelper
import io.reactivex.Observable
import javax.inject.Inject


class SignInteractor @Inject constructor(userRepoHelper: UserRepo, preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : BaseInteractor(userRepoHelper,preferenceHelper,apiHelper),
    SignInteractorImp {
    override fun doGoogleLoginApiCall(token: String?): Observable<LoginResponse> {
        return apiHelper.performGoogleLogin(LoginRequest.GoogleLoginRequest(token.toString()))
    }

    override fun doFBLoginApiCall(accessToken: AccessToken): Observable<LoginResponse> {
        return apiHelper.performFBLogin(LoginRequest.FacebookLoginRequest(accessToken.token))
    }


    override fun updateUser(loginResponse: LoginResponse) {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        var json = gson.toJson(loginResponse.user)
        var user: User = gson.fromJson(json.toString(), User::class.java)
        userHelper.insertRegister(user)
        preferenceHelper.let {
            it.setCurrentUserId(loginResponse.user?.id)
            it.setAccessToken(loginResponse.accessToken)
            it.setUserLoged(true)
        }
    }
}