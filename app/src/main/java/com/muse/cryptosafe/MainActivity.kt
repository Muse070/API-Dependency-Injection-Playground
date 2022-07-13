package com.muse.cryptosafe

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.muse.cryptosafe.data.remote.dto.PostResponse
import com.muse.cryptosafe.presentation.MyViewModel
import com.muse.cryptosafe.presentation.RetrofitViewModel
import com.muse.cryptosafe.ui.theme.CryptoSafeTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("ProduceStateDoesNotAssignValue")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: RetrofitViewModel by viewModels()

            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = viewModel.repo().getUser()
                }
            )
            
            CryptoSafeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp)
                    ) {
                            items(posts.value) {
                                Column {
                                    Text(
                                        text = it.title, fontSize = 20.sp
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Text(
                                        text = it.body, fontSize = 14.sp
                                    )
                                }
                        }
                    }
                }
            }
        }
    }
}