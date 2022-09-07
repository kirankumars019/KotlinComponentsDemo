package com.mrk.kotlincomponentsdemo.pagination.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mrk.kotlincomponentsdemo.pagination.repository.PaginationRepository
import java.lang.IllegalArgumentException

class PaginationViewModelFactory constructor(private val repository: PaginationRepository) :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return if (modelClass.isAssignableFrom(PaginationViewmodel::class.java)){
            PaginationViewmodel(this.repository) as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}