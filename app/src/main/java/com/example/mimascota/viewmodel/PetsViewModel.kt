package com.example.mimascota.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mimascota.models.AccesResultModel
import com.example.mimascota.models.UserAccessResult
import com.example.mimascota.repositories.UserAccessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class PetsViewModel @Inject constructor(
    var UserAccessRepository: UserAccessRepository
) : ViewModel() {

    // Ayuda a liberar los recursos cuando usamos programacion reactiva
    private val compositeDisposable = CompositeDisposable()

    val userAccesList: MutableLiveData<UserAccessResult> by lazy {
        MutableLiveData<UserAccessResult>()
    }

    fun getUserAccess() {
        compositeDisposable += UserAccessRepository.userAccess()
            .subscribeOn(Schedulers.io())
            .subscribe({ listProds ->
                userAccesList.postValue(
                    UserAccessResult(
                        susses = true,
                        list = listProds
                    )
                )
            }, {
                listRecipeBook.postValue(
                    RecipeBookResult(
                        susses = false
                    )
                )
            })
    }

   /* fun userAcces(email: String, idUser: String, password: String) {
        compositeDisposable += recipeBookRepository.userAccess(
            email = email, idUser = idUser, password = password
        )
            .subscribeOn(Schedulers.io())
            .subscribe(
                { accesResultModel ->
                    userAccess.postValue(accesResultModel)
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
    }*/

  /*  override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}*/
