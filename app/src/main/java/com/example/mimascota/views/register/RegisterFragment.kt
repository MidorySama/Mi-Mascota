package com.example.mimascota.views.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mimascota.activities.main.MainActivity
import com.example.mimascota.databinding.FragmentRegistroBinding
import com.example.mimascota.models.AccessResultModel
import com.example.mimascota.activities.screen.Screen
import com.example.mimascota.viewmodel.UserRegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    var binding: FragmentRegistroBinding? = null

    private val userRegisterModel: UserRegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistroBinding.inflate(LayoutInflater.from(context), null, false)

        initUserRegisterObserver()
        initListener()
        return binding?.root
    }

    // Este es mi Callback
    private val userRegisterResult = Observer<AccessResultModel> { accessResultModel ->
        if (accessResultModel.code == "0") {
            Toast.makeText(requireContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initUserRegisterObserver() {
        userRegisterModel.userRegisterr.observe(viewLifecycleOwner, userRegisterResult)
    }

    private fun UserRegisterRequest(
        name: String,
        lastName: String,
        email: String,
        password: String
    ) {
        userRegisterModel.userRegister(name, lastName, email, password)
    }

    private fun initListener() {

        binding?.tvRegresar?.setOnClickListener {
            (activity as MainActivity).changeScreenProccess(Screen.LoguinFragment)
        }

        binding?.tvGuardar?.setOnClickListener {
            if (binding?.etPassword?.text.toString() == binding?.etRepetPassword?.text.toString()) {
                UserRegisterRequest(
                    binding?.etNombre?.text.toString(),
                    binding?.etApellido?.text.toString(),
                    binding?.etemail?.text.toString(),
                    binding?.etPassword?.text.toString()
                )
            } else {
                Toast.makeText(requireContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
