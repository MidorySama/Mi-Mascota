package com.example.mimascota.views.loguin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.mimascota.activities.main.MainActivity
import com.example.mimascota.databinding.FragmentLoguinBinding
import com.example.mimascota.models.AccesResultModel
import com.example.mimascota.models.Screen
import com.example.mimascota.viewmodel.PetsViewModel
/*import com.example.mimascota.viewmodel.PetsViewModel*/
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoguinFragment : Fragment() {
    var binding: FragmentLoguinBinding? = null
    private val modelUserAccess: PetsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoguinBinding.inflate(
            LayoutInflater.from(context), null, false
        )
        initListener()
        return binding?.root
    }

    private fun initListener() {

        binding?.etUsuario?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.ListaMascotasFragment)
        }

        binding?.tvEntrar?.setOnClickListener {
            binding?.etUsuario?.text.toString()
            binding?.etPassword?.text.toString()
            (activity as MainActivity)
                .changeScreenProccess(Screen.ListaMascotasFragment)
        }

        binding?.tvIngresarInvi?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.InvitadoFragment)
        }

        binding?.tvRegister?.setOnClickListener {
            (activity as MainActivity)
                .changeScreenProccess(Screen.RegisterFragment)
        }
        //initLoginObserver()
    }

    // este es mi callback
    private val userAccess = Observer<AccesResultModel> { accesResultModel ->
        if (accesResultModel.code == "0") {
            (activity as MainActivity) // Asi se hace el responce redirect en el fragment
                .changeScreenProccess(Screen.ListaMascotasFragment)
        } else {
            Toast.makeText(requireContext(), "Incorrect user or password", Toast.LENGTH_SHORT)
                .show()
        }
    }
/*
    private fun initLoginObserver() {
        modelUserAccess.userAccesList.observe(this,userAccess)
    }

    fun userAccess(email: String, pasword: String) {
       modelUserAccess.userAcces(email, pasword)
    }*/

    companion object {

        @JvmStatic
        fun newInstance() =
            LoguinFragment().apply {
                arguments = Bundle().apply { }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
