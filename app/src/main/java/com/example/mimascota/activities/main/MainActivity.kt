package com.example.mimascota.activities.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.mimascota.R
import com.example.mimascota.databinding.ActivityMainBinding
import com.example.mimascota.models.Screen
import com.example.mimascota.viewmodel.LoginViewModel
import com.example.mimascota.views.invitado.InvitadoFragment
import com.example.mimascota.views.loguin.LoguinFragment
import com.example.mimascota.views.register.RegisterFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    private val modelUserAcces: LoginViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        changeScreenProccess(Screen.LoguinFragment)
    }
    /*  private var userLoginObserver = Observer<UserAccesResult> { userLogin ->
       if (userLogin.susses) {
           userLogin.list?.let {
               val adapter = LoginAdapter(
                   *//*it,
                    onItemClickListener,
                    applicationContext*//*
                )
               *//* binding?.recyclerView?.adapter = adapter
                adapter.notifyDataSetChanged()*//*
            }
        }
    }*/

  /*  private var onItemClickListener: ((listAll: ListAllPets) -> Unit) = { list ->
        Toast.makeText(this, "Macota:" + list.name, Toast.LENGTH_SHORT).show()
        LoginDetBottomSheet.newInstance(
            list.name,
            list.type,
            list.raza,
            list.obs,
            list.url_image
        )
            .show(supportFragmentManager, "")
    }
*/
    /*  private fun initRecycler() {
          val linearLayoutManager = LinearLayoutManager(this)
          binding?.recyclerView?.apply {
              layoutManager = linearLayoutManager
              isNestedScrollingEnabled = false
              setHasFixedSize(true)
              // itemAnimator = DefaultItemAnimator()
          }
      }*/

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
            // Screen.Salir->{finish()}
        }
    }



    /* private fun initLoginObserver() {
         modelUserAcces.userAccess.observe(this, userLoginObserver)
     }*/

    fun userAccess(email: String,pasword: String) {
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


