package com.example.mimascota.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mimascota.mapping.UserAccesResult
import com.example.mimascota.repositories.UserAccessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class PetsViewModel @Inject constructor(
    var userAccessRepository: UserAccessRepository
) : ViewModel() {

    // Ayuda a liberar los recursos cuando usamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val listPets: MutableLiveData<UserAccesResult> by lazy {
        MutableLiveData<UserAccesResult>()
    }

    /*fun listMascota() {
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
    }*/

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}
