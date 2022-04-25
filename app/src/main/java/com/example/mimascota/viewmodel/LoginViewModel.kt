package com.example.mimascota.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mimascota.models.AccessResultModel
import com.example.mimascota.models.UserAccesResult
import com.example.mimascota.repositories.UserAccessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    var userAccessRepository: UserAccessRepository
) : ViewModel() {

    // Ayuda a liberar los recursos cuando usamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val userAcces: MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    val listPets: MutableLiveData<UserAccesResult> by lazy {
        MutableLiveData<UserAccesResult>()
    }

    fun listMascota() {
        compositeDisposable += userAccessRepository.userAccess()
            .subscribeOn(Schedulers.io())
            .subscribe({ listA ->
                listPets.postValue(
                    UserAccesResult(
                        susses = true,
                        list = listA
                    )
                )
            }, {
                listPets.postValue(
                    UserAccesResult(
                        susses = false
                    )
                )
            })
    }

    fun userAccess(email: String, idUser: String, password: String) {
        compositeDisposable += userAccessRepository.userAccess(
            email = email, password = password
        )
            .subscribeOn(Schedulers.io())
            .subscribe(
                { accesResultModel ->
                    userAcces.postValue(accesResultModel)
                },
                { error ->
                    userAcces.postValue(
                        AccesResultModel(
                            code = "1",
                            message = "error!",
                        )
                    )
                }
            )
    }


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
