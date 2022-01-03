package com.example.userauth.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.userauth.R
import com.example.userauth.model.repo.Outcome
import com.example.userauth.viewModel.SignUpViewModel
import kotlinx.android.synthetic.main.fragment_sign_up.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class SignUpFragment : Fragment() {
    private val signUpViewModel: SignUpViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signInClick.setOnClickListener {
            findNavController().navigateUp()
        }

        signUpBtn.setOnClickListener {
            signUpViewModel.signUp(signUpEtName.text.toString(),signUpEtEmail.text.toString(),signUpEtPassword.text.toString()).observe(viewLifecycleOwner, androidx.lifecycle.Observer { outcome->
                when(outcome){
                    is Outcome.Success ->{
                        if(outcome.data.status == true){
                            findNavController().navigate(R.id.signInFragment)

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
    }

}