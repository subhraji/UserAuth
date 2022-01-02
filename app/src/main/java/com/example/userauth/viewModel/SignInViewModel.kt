package com.example.userauth.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.userauth.model.repo.sign_In.SignInRepository
import com.example.userauth.model.repo.sign_up.SignUpRepository

class SignInViewModel(private val mSignInRepository: SignInRepository): ViewModel() {

    fun signIn(email: String,password: String) = liveData {
        emit(mSignInRepository.signIn(email,password))
    }
}