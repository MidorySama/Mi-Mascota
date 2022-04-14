package com.example.mimascota.views.component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mimascota.activities.main.MainActivity
import com.example.mimascota.databinding.FragmentLoguinBinding
import com.example.mimascota.models.Screen
import com.example.mimascota.views.loguin.LoguinFragment
import dagger.hilt.android.AndroidEntryPoint

/*
@AndroidEntryPoint
class MenuFragment : Fragment() {
    //solo en los fragments se pone null
    var binding: FragmentLoguinBinding ? = null
    // private val userAccessViewModel: PetsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View? { // Inflate the layout for this fragment
            binding = FragmentLoguinBinding.inflate(
                LayoutInflater.from(context),null,false)

            initListener()
            return binding?.root
        }


    private fun initListener() {

        binding?.tvSalir?.setOnClickListener{
            (activity as MainActivity)
                .changeScreenProccess(Screen.LoguinFragment)
        }

        binding?.etUsuario?.setOnClickListener{
            (activity as MainActivity)
                .changeScreenProccess(Screen.ListaMascotasFragment)
        }

        binding?.tvEntrar?.setOnClickListener{
            (activity as MainActivity)
                .changeScreenProccess(Screen.ListaMascotasFragment)
        }

        binding?.tvIngresarInvi?.setOnClickListener{
            (activity as MainActivity)
                .changeScreenProccess(Screen.InvitadoFragment)
        }

        binding?.tvRegister?.setOnClickListener{
            (activity as MainActivity)
                .changeScreenProccess(Screen.RegisterFragment)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoguinFragment().apply {
                arguments = Bundle().apply {   }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
*/
