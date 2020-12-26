package com.loginmvp.domain.Interactor.Logininteractor

import com.google.firebase.auth.FirebaseAuth

class SignInInteractorImpl: SingInInteractor {

    override fun signInWithEmailAndPassword(email: String, password: String,
             listener: SingInInteractor.SignInCallback) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if(it.isSuccessful){
                    listener.onSignInSuccess()
                }else{
                    listener.onSignInFailure(it.exception?.message!!)
                }
            }
    }
}