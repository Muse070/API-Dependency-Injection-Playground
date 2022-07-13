package com.muse.cryptosafe.presentation

import androidx.lifecycle.ViewModel
import com.muse.cryptosafe.data.repository.MyRepositoryImpl
import com.muse.cryptosafe.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepositoryImpl
): ViewModel() {

    fun repo(): MyRepository {
        return repository
    }
}