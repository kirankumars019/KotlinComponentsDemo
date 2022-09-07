package com.mrk.kotlincomponentsdemo.pagination.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.mrk.kotlincomponentsdemo.pagination.UserSource
import com.mrk.kotlincomponentsdemo.pagination.model.ContentModule
import com.mrk.kotlincomponentsdemo.pagination.repository.PaginationRepository
import com.mrk.kotlincomponentsdemo.pagination.service.PaginationApi
import com.mrk.kotlincomponentsdemo.retrofit.model.UserModel
import kotlinx.coroutines.flow.Flow

class PaginationViewmodel(
    //private val paginationApi: PaginationApi
    private val paginationRepository: PaginationRepository
) : ViewModel() {

    private val TAG = "PaginationViewmodel"


    //val errorMessage = MutableLiveData<String>()

    fun getPagingData(): LiveData<PagingData<ContentModule>> {
        Log.e(TAG, "getPagingData: called ")

        return paginationRepository.getPagingData().cachedIn(viewModelScope)
    }


}