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

package com.loginmvp.presentation.login.view


import android.content.Intent
import android.os.Bundle
import android.view.View
import com.loginmvp.R
import com.loginmvp.base.BaseActivity
import com.loginmvp.domain.Interactor.Logininteractor.SignInInteractorImpl
import com.loginmvp.presentation.login.LoginContract
import com.loginmvp.presentation.login.presenter.LoginPresenter
import com.loginmvp.presentation.main.view.MainActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity() , LoginContract.LoginView {

    lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = LoginPresenter(SignInInteractorImpl())
        presenter.attachView(this)
        btn_signIn.setOnClickListener{
            signIn()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun showError(msgError: String) {
        toast(this, msgError)
    }

    override fun showProgressDialog() {
        progressBar_signIn.visibility = View.VISIBLE
    }

    override fun hideProgressDialog() {
        progressBar_signIn.visibility = View.GONE
    }

    override fun signIn() {
        val email = etxt_email.text.toString().trim()
        val password = etxt_password.text.toString().trim()

        if(presenter.checkEmptyFields(email,password)) {
            toast(this, "Uno o ambos estan vacios")
        }else {
            presenter.signInUserWithEmailAndPassword(email, password)
        }

    }

    override fun navigateToMain() {
        //Evita que cuando inicie sesion se pueda volver a la pantalla de login con '>'
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun navigateToRegister() {
        TODO("Not yet implemented")
        //startActivity(Intent(this,RegisterActivity::class.java))
    }
}

