package com.example.mimascota.activities.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mimascota.R
import com.example.mimascota.databinding.ActivityMainBinding
import com.example.mimascota.models.Screen
import com.example.mimascota.views.register.RegisterFragment
import com.example.mimascota.views.invitado.InvitadoFragment
import com.example.mimascota.views.loguin.LoguinFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        changeScreenProccess(Screen.LoguinFragment)
    }

    fun changeFragment(fragment: Fragment) {
        val cam: FragmentTransaction = supportFragmentManager.beginTransaction()
        cam.replace(R.id.Fragment_Principal, fragment)
        cam.commit()
    }

    fun changeScreenProccess(typeScreen: Screen){
        when(typeScreen){
       /*     Screen.MenuFragment->{
                openMenuFragment()
            }*/
            Screen.LoguinFragment->{
                openLoguinFragment()}
            Screen.RegisterFragment-> {
                openRegisterFragment()}
            Screen.InvitadoFragment->{
                openInvitadoFragment()}
           // Screen.Salir->{finish()}
        }
    }

    fun openLoguinFragment()
    {
        changeFragment(LoguinFragment.newInstance())
    }
    fun openRegisterFragment()
    {
        changeFragment(RegisterFragment.newInstance())
    }
    fun openInvitadoFragment()
    {
        changeFragment(InvitadoFragment.newInstance())
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoguinFragment().apply {
                arguments = Bundle().apply {   }
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}