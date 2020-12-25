package com.loginmvp.presentation.login

interface LoginContract {
    interface View {
        fun showError(msgError: String)
        fun showProgressDialog()
        fun hideProgressDialog()
        fun signIn()
    }
}