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

package com.loginmvp.presentation.registro.presenter

import androidx.core.util.PatternsCompat
import com.loginmvp.presentation.registro.RegisterContract
import com.loginmvp.presentation.registro.RegisterContract.RegisterView

class RegisterPresenter(): RegisterContract.RegisterPresenter{

    var view: RegisterView? = null

    override fun attachView(view: RegisterView){ this. view = view }

    override fun detachView() { view = null }

    override fun isViewAttached(): Boolean { return view != null }

    override fun checkEmptyNameAndEmail(fullname: String, email: String): Boolean {
        return fullname.isEmpty() || email.isEmpty()
    }

    override fun checkValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun checkEmptyPasswords(pw1: String, pw2: String): Boolean {
        return pw1.isEmpty() or pw2.isEmpty()
    }

    override fun checkPasswordsMatch(pw1: String, pw2: String): Boolean {
        return pw1 == pw2
    }

    override fun signUp(fullname: String, email: String, password: String) {
        TODO("Not yet implemented")
    }
}