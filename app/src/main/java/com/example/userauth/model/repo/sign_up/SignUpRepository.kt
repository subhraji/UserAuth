package com.example.userauth.model.repo.sign_up

import com.example.userauth.model.pojo.SignUpModel
import com.example.userauth.model.repo.Outcome

interface SignUpRepository {

    suspend fun signUp(name: String,email:String, password:String): Outcome<SignUpModel>

}