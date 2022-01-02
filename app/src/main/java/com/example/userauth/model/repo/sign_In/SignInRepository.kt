package com.example.userauth.model.repo.sign_In

import com.example.userauth.model.pojo.SignUpModel
import com.example.userauth.model.repo.Outcome

interface SignInRepository {
    suspend fun signIn(email:String, password:String): Outcome<SignUpModel>

}