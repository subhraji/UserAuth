package com.example.userauth.model.repo.sign_up

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.userauth.model.network.ApiClient
import com.example.userauth.model.pojo.SignUpModel
import com.example.userauth.model.pojo.SignUpRequestModel
import com.example.userauth.model.repo.Outcome

class SignUpRepositoryImpl(private val context: Context): SignUpRepository {

    private val apiService = ApiClient.getInstance(context)

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Outcome<SignUpModel> {

        val apiResponse = MutableLiveData<Outcome<SignUpModel>>()
        try {
            val response = apiService.signUp(SignUpRequestModel(name,email,password))
            apiResponse.value = Outcome.success(response!!)
        } catch (e: Throwable) {
            apiResponse.value = Outcome.failure(e)
        }

        return apiResponse.value as Outcome<SignUpModel>
    }


}