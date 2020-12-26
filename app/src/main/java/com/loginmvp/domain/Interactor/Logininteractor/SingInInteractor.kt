package com.loginmvp.domain.Interactor.Logininteractor

interface SingInInteractor {
    interface SignInCallback{
        fun onSignInSuccess()
        fun onSignInFailure(errorMsg : String)
    }

    fun signInWithEmailAndPassword(email: String, password: String, listener: SignInCallback)
}