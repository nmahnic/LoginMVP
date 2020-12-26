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
        //TODO("Not yet implemented")
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun navigateToRegister() {
        TODO("Not yet implemented")
        //startActivity(Intent(this,RegisterActivity::class.java))
    }
}

