package com.loginmvp.presentation.login.view


import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import com.loginmvp.R
import com.loginmvp.base.BaseActivity
import com.loginmvp.presentation.login.LoginContract

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() , LoginContract.View{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btn_signIn.setOnClickListener{
            signIn()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
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

    var i = false
    override fun signIn() {

        toast(this,"Prueba Boton ${i}")
        if(i == true){
            i=false
            hideProgressDialog()
        }else{
            i= true
            showProgressDialog()
        }
    }
}

