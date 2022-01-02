package com.example.userauth.model.network

import com.example.userauth.model.pojo.SignUpModel
import com.example.userauth.model.pojo.SignUpRequestModel
import com.example.userauth.model.pojo.SigninRequestModel
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("/signUp")
    suspend fun signUp(@Body body: SignUpRequestModel?): SignUpModel?

    @POST("/signIn")
    suspend fun signIn(@Body body: SigninRequestModel?): SignUpModel?
}