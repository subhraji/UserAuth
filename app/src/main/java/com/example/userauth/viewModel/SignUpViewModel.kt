package com.example.userauth.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.userauth.model.pojo.SignUpModel
import com.example.userauth.model.pojo.SignUpRequestModel
import com.example.userauth.model.repo.sign_up.SignUpRepository
import retrofit2.http.Body
import retrofit2.http.POST

class SignUpViewModel(private val mSignUpRepository: SignUpRepository): ViewModel() {

    fun signUp(name: String,email: String,password: String) = liveData {
        emit(mSignUpRepository.signUp(name,email,password))
    }
}