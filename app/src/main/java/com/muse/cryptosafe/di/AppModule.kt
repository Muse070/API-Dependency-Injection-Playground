package com.muse.cryptosafe.di

import com.muse.cryptosafe.data.remote.RetrofitApi
import com.muse.cryptosafe.data.repository.MyRepositoryImpl
import com.muse.cryptosafe.data.repository.RetrofitImpl
import com.muse.cryptosafe.data.source.HttpRoutes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    object RequestInterceptor : Interceptor {
//        override fun intercept(chain: Interceptor.Chain): Response {
//            val request = chain.request()
//            println("Outgoing request to ${request.url}")
//            return chain.proceed(request)
//        }
//    }

    private val okHttpClient = OkHttpClient()
        .newBuilder()
        //.addInterceptor(RequestInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideJsonApi() = HttpClient(Android) {
        install(ContentNegotiation) {
                json()
        }
    }

    @Provides
    @Singleton
    fun provideMyRepositoryImpl(client: HttpClient) = MyRepositoryImpl(client)

    @Provides
    @Singleton
    fun provideApi(builder:Retrofit.Builder):RetrofitApi {
        return builder
            .build()
            .create(RetrofitApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(HttpRoutes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

}