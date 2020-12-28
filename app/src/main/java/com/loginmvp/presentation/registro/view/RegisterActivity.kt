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

package com.loginmvp.presentation.registro.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.loginmvp.R
import com.loginmvp.base.BaseActivity
import com.loginmvp.presentation.main.view.MainActivity
import com.loginmvp.presentation.registro.presenter.RegisterPresenter
import com.loginmvp.presentation.registro.RegisterContract
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), RegisterContract.RegisterView {

    lateinit var presenter : RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = RegisterPresenter()
        presenter.attachView(this)
        btn_signUp.setOnClickListener{
            signUp()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_register
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
    override fun signUp() {
        //TODO("Not yet implemented")
        showProgress()
        showError("ENTRE")
    }

    override fun showProgress() {
        progressBar_signUp.visibility = View.VISIBLE
        btn_signUp.visibility = View.GONE
    }

    override fun hideProgress() {
        progressBar_signUp.visibility = View.GONE
        btn_signUp.visibility = View.VISIBLE
    }

    override fun showError(msgError: String) {
        toast(this,msgError)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}