package com.example.userauth.model.repo.sign_In

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.userauth.model.network.ApiClient
import com.example.userauth.model.pojo.SignUpModel
import com.example.userauth.model.pojo.SignUpRequestModel
import com.example.userauth.model.pojo.SigninRequestModel
import com.example.userauth.model.repo.Outcome
import com.example.userauth.model.repo.sign_up.SignUpRepository

class SignInRepositoryImpl(private val context: Context): SignInRepository {
    private val apiService = ApiClient.getInstance(context)

    override suspend fun signIn(email: String, password: String): Outcome<SignUpModel> {

        val apiResponse = MutableLiveData<Outcome<SignUpModel>>()
        try {
            val response = apiService.signIn(SigninRequestModel(email,password))
            apiResponse.value = Outcome.success(response!!)
        } catch (e: Throwable) {
            apiResponse.value = Outcome.failure(e)
        }

        return apiResponse.value as Outcome<SignUpModel>
    }

}