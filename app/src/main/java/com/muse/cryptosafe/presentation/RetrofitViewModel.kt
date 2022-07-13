package com.muse.cryptosafe.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muse.cryptosafe.data.remote.RetrofitApi
import com.muse.cryptosafe.data.remote.dto.PostResponse
import com.muse.cryptosafe.data.repository.RetrofitImpl
import com.muse.cryptosafe.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RetrofitViewModel @Inject constructor(
    private val postResponse: RetrofitImpl
): ViewModel() {

//    private val _state = MutableStateFlow(emptyList<PostResponse>())
//    val state: StateFlow<List<PostResponse>>
//        get() = _state
//
//    init {
//
//        viewModelScope.launch{
//            val post = postResponse.getUser()
//            _state.value = post
//        }
//    }

    fun repo(): RetrofitApi {
        return postResponse
    }
}