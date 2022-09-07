package com.mrk.kotlincomponentsdemo.pagination.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.*
import com.mrk.kotlincomponentsdemo.pagination.UserSource
import com.mrk.kotlincomponentsdemo.pagination.model.ContentModule
import com.mrk.kotlincomponentsdemo.pagination.service.PaginationApi

class PaginationRepository(private val paginationApi: PaginationApi) {


    private val TAG = "PaginationRepository"

    fun  getPagingData(): LiveData<PagingData<ContentModule>> {
        Log.e(TAG, "getPagingData: called ", )

        return Pager(
            config = PagingConfig(
                pageSize = 1,
                maxSize = 200
               // enablePlaceholders = false,
                //initialLoadSize = 2
            ), pagingSourceFactory = {
                  UserSource(paginationApi)
            }
        //, initialKey = 1
        ).liveData
    }


}