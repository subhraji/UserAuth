package com.example.userauth

import com.example.userauth.model.repo.sign_In.SignInRepository
import com.example.userauth.model.repo.sign_In.SignInRepositoryImpl
import com.example.userauth.model.repo.sign_up.SignUpRepository
import com.example.userauth.model.repo.sign_up.SignUpRepositoryImpl
import com.example.userauth.viewModel.SignInViewModel
import com.example.userauth.viewModel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single<SignUpRepository> { SignUpRepositoryImpl(get()) }
    viewModel { SignUpViewModel(get()) }

    single<SignInRepository> { SignInRepositoryImpl(get()) }
    viewModel { SignInViewModel(get()) }
}