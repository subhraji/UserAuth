package com.example.userauth.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.userauth.MainActivity
import com.example.userauth.R
import com.example.userauth.model.repo.Outcome
import com.example.userauth.view.activity.LoginActivity
import com.example.userauth.viewModel.SignInViewModel
import com.example.userauth.viewModel.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignInFragment : Fragment() {
    private val signInViewModel: SignInViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpClick.setOnClickListener {

            signInViewModel.signIn(etEmail.text.toString(),etPassword.text.toString()).observe(viewLifecycleOwner, androidx.lifecycle.Observer { outcome->
                when(outcome){
                    is Outcome.Success ->{
                        if(outcome.data.status == true){
                            val intent = Intent(activity, MainActivity::class.java)
                            intent.putExtra("name", outcome.data.data.user.name)
                            intent.putExtra("email", outcome.data.data.user.email)
                            startActivity(intent)
                            requireActivity().finish()
                        }else{
                            Toast.makeText(activity,"error !!!", Toast.LENGTH_SHORT).show()
                        }
                    }

                    is Outcome.Failure<*> -> {
                        Toast.makeText(activity,outcome.e.message, Toast.LENGTH_SHORT).show()

                        outcome.e.printStackTrace()
                        Log.i("status",outcome.e.cause.toString())
                    }
                }
            })

        }

        signInBtn.setOnClickListener {
            val intent = Intent(requireActivity(), MainActivity::class.java)
            startActivity(intent)
        }
    }

}