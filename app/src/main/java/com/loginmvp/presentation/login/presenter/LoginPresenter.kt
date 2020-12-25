package com.loginmvp.presentation.login.presenter


import com.loginmvp.presentation.login.LoginContract

class LoginPresenter() : LoginContract.LoginPresenter {

    var view: LoginContract.LoginView? = null

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
        //TODO("Not yet implemented")
        view?.showProgressDialog()
        view?.showError("Hola desde el presenter")
        // Llamar al interactor...
    }

    override fun checkEmptyFields(email: String, password: String) : Boolean{
        return email.isEmpty() || password.isEmpty()
    }
}