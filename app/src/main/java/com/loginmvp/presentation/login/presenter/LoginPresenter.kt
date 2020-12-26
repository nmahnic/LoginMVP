/*
 *
 *  * Copyright (C) 2019 Gastón Luis Saillén.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.loginmvp.presentation.login.presenter


import com.loginmvp.domain.Interactor.Logininteractor.SingInInteractor
import com.loginmvp.presentation.login.LoginContract

class LoginPresenter(signInInteractor: SingInInteractor) : LoginContract.LoginPresenter {

    var signInInteractor : SingInInteractor? = null
    var view: LoginContract.LoginView? = null

    init {
        this.signInInteractor = signInInteractor
    }

    override fun attachView(view: LoginContract.LoginView) {
        // Como ambos objetos tienen el mismo nombre para hacer referenia al propio de la clase se
        // se le agrega el this, en los demas casos no es necesario (dettach o isViewAttached)
        this. view = view
        // La vista que acabamos de crear va a ser igual al view del activity
    }

    override fun detachView() {
        view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }

    override fun signInUserWithEmailAndPassword(email: String, password: String) {
        view?.showProgressDialog()
        signInInteractor?.signInWithEmailAndPassword(email,password,object : SingInInteractor.SignInCallback{
            override fun onSignInSuccess() {
                if(isViewAttached()){
                    view?.hideProgressDialog()
                    view?.navigateToMain()
                }
            }

            override fun onSignInFailure(errorMsg: String) {
                if(isViewAttached()){
                    view?.hideProgressDialog()
                    view?.showError(errorMsg)
                }
            }
        })
    }

    override fun checkEmptyFields(email: String, password: String) : Boolean{
        return email.isEmpty() || password.isEmpty()
    }
}