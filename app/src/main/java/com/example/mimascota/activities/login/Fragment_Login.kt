package com.example.mimascota.activities.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import com.example.mimascota.R
import com.example.mimascota.activities.screen.Screen
import com.example.mimascota.viewmodel.LoginViewModel
import com.example.mimascota.views.invitado.InvitadoFragment
import com.example.mimascota.views.loguin.LoguinFragment
import com.example.mimascota.views.register.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Fragment_Login : Fragment() {

    //lateinit var binding: ActivityMainBinding
    var binding: ActivityMainBinding? = null
    private val modelUserAcces: LoginViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        changeScreenProccess(Screen.LoguinFragment)

        binding?.tvEntrar?.setOnClickListener{

            userAcces(binding?.edUsuario?.text.toString(),binding?.etPassword?.text.toString())
        }


    }


    fun changeFragment(fragment: Fragment) {
        val cam: FragmentTransaction = supportFragmentManager.beginTransaction()
        cam.replace(R.id.Fragment_Principal, fragment)
        cam.commit()
    }

    fun changeScreenProccess(typeScreen: Screen) {
        when (typeScreen) {
            Screen.LoguinFragment -> {
                openLoguinFragment()
            }
            Screen.RegisterFragment -> {
                openRegisterFragment()
            }
            Screen.InvitadoFragment -> {
                openInvitadoFragment()
            }
            //Screen.Salir->{finish()}
        }
    }


    /* private fun initLoginObserver() {
         modelUserAcces.userAccess.observe(this, userLoginObserver)
     }*/

    fun userAcces(email: String, pasword: String) {
        modelUserAcces.userAccess(email, pasword)
    }

    fun openLoguinFragment() {
        changeFragment(LoguinFragment.newInstance())
    }

    fun openRegisterFragment() {
        changeFragment(RegisterFragment.newInstance())
    }

    fun openInvitadoFragment() {
        changeFragment(InvitadoFragment.newInstance())
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoguinFragment().apply {
                arguments = Bundle().apply { }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}
