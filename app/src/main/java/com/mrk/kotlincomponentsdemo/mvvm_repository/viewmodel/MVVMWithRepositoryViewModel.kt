package com.mrk.kotlincomponentsdemo.mvvm_repository.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mrk.kotlincomponentsdemo.mvvm_repository.repository.MVVMRepository
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel

class MVVMWithRepositoryViewModel
constructor(
    //private val mvvmRepository: MVVMRepository
    ): ViewModel() {

    /*var userModelList: MutableLiveData<List<UserModel.Data>?>? = null

    private val mvvmRepository= MVVMRepository.getInstance()*/
    private val TAG = "MVVMViewModel"

    //reduced code
    fun getAllUserModels(): MutableLiveData<List<UserModel.Data>?>? {
        return MVVMRepository().getAllMovies()
    }


    //Todo: this also works fine but code is more
    /*fun getAllUserModelsNew(): MutableLiveData<List<UserModel.Data>?>? {

        userModelList = mvvmRepository.getAllMovies()

        Log.e(TAG, "getUsers: $userModelList")
        return userModelList
    }*/

/* val response = mvvmRepository.getAllMovies()

        response?.enqueue(object: Callback<List<UserModel>> {
            override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {
                userModelList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })*//*

        return userModelList
    }
*/


}