package com.example.mimascota.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mimascota.models.AccessResultModel
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

    val userAccess: MutableLiveData<AccessResultModel> by lazy {
        MutableLiveData<AccessResultModel>()
    }

    fun userAccess(email: String, password: String) {
        compositeDisposable += userAccessRepository.userAccess(
            email = email, password = password
        )
            .subscribeOn(Schedulers.io())
            .subscribe(
                { accesResultModel ->
                    userAccess.postValue(accesResultModel)
                },
                { error ->
                    userAccess.postValue(
                        AccessResultModel(
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
