package com.example.mimascota.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mimascota.models.AccesResultModel
import com.example.mimascota.repositories.UserRegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class UserRegisterViewModel @Inject constructor(
    var userRegisterRepository: UserRegisterRepository
) : ViewModel() {

    // libera los recursos al usar programación reactiva
    private val compositeDisposable = CompositeDisposable()

    val userRegisterr: MutableLiveData<AccesResultModel> by lazy {
        MutableLiveData<AccesResultModel>()
    }

    fun userRegister(email: String, name: String, lastName: String, password: String) {
        compositeDisposable += userRegisterRepository.userRegister(
            name = name, lastName = lastName, email = email, password = password,
        )
            .subscribeOn(Schedulers.io())
            .subscribe({ accesResultmodel ->
                userRegisterr.postValue(accesResultmodel)
            }, {
                userRegisterr.postValue(
                    AccesResultModel(
                        code = "-1",
                        message = "error!"
                    )
                )
            })
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
