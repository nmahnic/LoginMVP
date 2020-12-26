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

    override fun dettachView() {
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