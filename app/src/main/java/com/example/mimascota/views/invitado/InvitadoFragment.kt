package com.example.mimascota.views.invitado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mimascota.activities.main.MainActivity
import com.example.mimascota.databinding.FragmentInvitadoBinding
import com.example.mimascota.models.Screen


class InvitadoFragment : Fragment() {

    var binding: FragmentInvitadoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInvitadoBinding.inflate(LayoutInflater.from(context),null,false)

        initListener()
        return binding?.root
    }

    private fun initListener() {

        binding?.tvSalir?.setOnClickListener{
            (activity as MainActivity).changeScreenProccess(Screen.LoguinFragment)
        }
    }

    companion object {

            @JvmStatic
            fun newInstance() =
                InvitadoFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
        }
    }

